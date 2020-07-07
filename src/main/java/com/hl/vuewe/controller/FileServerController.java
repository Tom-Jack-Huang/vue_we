package com.hl.vuewe.controller;

import com.hl.vuewe.utils.FtpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;


/**
 * @author apple
 */
@Controller
@RequestMapping("file")
public class FileServerController {

    @Value("${file-save-path}")
    private String fileSavePath;

    @Value("${app.base}")
    private String baseUrl;

    @PostMapping("uploadFileToFtp")
    @ResponseBody
    private Object uploadFileToFtp(MultipartFile multipartFile,String fileName) throws Exception {
        HashMap<String,Object> resultMap = new HashMap<String, Object>(16);
        resultMap.put("result",true);
        resultMap.put("msg","数据获取成功！");
      if (multipartFile != null) {
          FtpUtils ftpUtils = new FtpUtils();
          boolean isOk = ftpUtils.uploadFile("/vue",fileName,multipartFile.getInputStream());
          if (!isOk) {
              resultMap.put("result",false);
              resultMap.put("msg","文件上传失败");
          }
      } else  {
          resultMap.put("result",false);
          resultMap.put("msg","文件为空");
      }
        return resultMap;
    }

    @PostMapping("downloadFileFromFtp")
    @ResponseBody
    private Object downloadFileFromFtp(String fileName) throws Exception {
        HashMap<String,Object> resultMap = new HashMap<String, Object>(16);
        resultMap.put("result",true);
        resultMap.put("msg","数据获取成功！");
        if (fileName == null) {
            resultMap.put("result",false);
            resultMap.put("msg","请输入需要下载的文件");
            return resultMap;
        }
        FtpUtils ftpUtils = new FtpUtils();
        boolean isOk = ftpUtils.downloadFile("/vue",fileName,"C:\\Users\\Administrator\\Desktop\\xiangmu\\h5");
        if (!isOk) {
            resultMap.put("result",false);
            resultMap.put("msg","文件下载失败");
            return resultMap;
        }
        return resultMap;
    }

    @PostMapping("uploadFile")
    @ResponseBody
    private Object uploadFile(MultipartFile multipartFile) throws Exception {
        HashMap<String,Object> resultMap = new HashMap<String, Object>(16);
        resultMap.put("result",true);
        resultMap.put("msg","数据获取成功！");
        if (Objects.isNull(multipartFile)) {
            resultMap.put("result",false);
            resultMap.put("msg","文件为空");
            return resultMap;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String uuid = UUID.randomUUID().toString().replace("-","");
        String time = simpleDateFormat.format(new Date());
        try {
            File file = new File(fileSavePath);
            if (!file.exists()) {
               boolean isOk = file.mkdir();
            }
            //后缀
            String suffix = Objects.requireNonNull(multipartFile.getOriginalFilename()).substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            String fileName = uuid+time+suffix;
            resultMap.put("fileName",fileName);
            File createFile = new File(fileSavePath+fileName);
            multipartFile.transferTo(createFile);
            String url = baseUrl+"/file/"+fileName;
            resultMap.put("filePath",url);
        } catch (Exception e) {
            System.out.println(e);
            resultMap.put("result",false);
            resultMap.put("msg","文件上传失败");
            return resultMap;
        }
        return resultMap;
    }

}
