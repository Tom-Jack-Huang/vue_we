package com.hl.vuewe.controller;

import com.hl.vuewe.utils.FtpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;


/**
 * @author apple
 */
@Controller
@RequestMapping("file")
public class FileServerController {


    @PostMapping("uploadFile")
    @ResponseBody
    private Object uploadFile(MultipartFile multipartFile,String fileName) throws Exception {
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

    @PostMapping("downloadFile")
    @ResponseBody
    private Object downLoadFile(String fileName) throws Exception {
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
    @GetMapping("show")
    @ResponseBody
    private Object show(String fileName) throws Exception {
        FtpUtils ftpUtils = new FtpUtils();
        return ftpUtils.show(fileName);
    }

}
