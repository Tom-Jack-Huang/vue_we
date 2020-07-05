package com.hl.vuewe.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author Administrator
 */

public class FtpUtils {

    /**
     * ftp服务器地址
     */
    private final String hostname = "49.232.195.165";
    /**
     * ftp服务器端口号默认为21
     */
    private final Integer port = 30021 ;
    /**
     * ftp登录账号
     */
    private final String username = "ftpServer";
    /**
     * ftp登录密码
     */
    private final String password = "18755138.Bb8487";

    private final String filePath = "/www/ftpServer/vue/";



    public FTPClient ftpClient = null;

    /**
     * 初始化ftp服务器
     */
    public void initFtpClient() throws Exception{
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("GBK");
        System.out.println("connecting...ftp服务器:"+hostname+":"+port);
        //连接ftp服务器
        ftpClient.connect(hostname, port);
        //登录ftp服务器
        ftpClient.login(username, password);
        ftpClient.enterLocalPassiveMode();
        //是否成功登录服务器
        int replyCode = ftpClient.getReplyCode();
        if(!FTPReply.isPositiveCompletion(replyCode)){
            System.out.println("connect failed...ftp服务器:"+this.hostname+":"+this.port);
        }
        System.out.println("connect successfu...ftp服务器:"+this.hostname+":"+this.port);
    }

    /**
     * 上传文件
     * @param pathname ftp服务保存地址
     * @param fileName 上传到ftp的文件名
     *  @param originfilename 待上传文件的名称（绝对地址） *
     * @return
     */
    public boolean uploadFile( String pathname, String fileName,String originfilename) throws Exception{
        boolean flag = false;
        InputStream inputStream = null;
        System.out.println("开始上传文件");
       try {
           inputStream = new FileInputStream(new File(originfilename));
           initFtpClient();
           ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
           CreateDirecroty(pathname);
           ftpClient.makeDirectory(pathname);
           ftpClient.changeWorkingDirectory(pathname);
           ftpClient.storeFile(fileName, inputStream);
           inputStream.close();
           ftpClient.logout();
           flag = true;
           System.out.println("上传文件成功");
       } catch (Exception e) {
           flag = false;
           System.out.println(e);
       }
        return flag;
    }
    /**
     * 上传文件
     * @param pathname ftp服务保存地址
     * @param fileName 上传到ftp的文件名
     * @param inputStream 输入文件流
     * @return
     */
    public boolean uploadFile( String pathname, String fileName,InputStream inputStream) throws Exception{
        boolean flag = false;
        System.out.println("开始上传文件");
        try {
            initFtpClient();
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            CreateDirecroty(pathname);
            ftpClient.makeDirectory(pathname);
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
            System.out.println("上传文件成功");
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }
    //改变目录路径
    public boolean changeWorkingDirectory(String directory) throws Exception{
        boolean flag = true;
        flag = ftpClient.changeWorkingDirectory(directory);
        if (flag) {
            System.out.println("进入文件夹" + directory + " 成功！");

        } else {
            System.out.println("进入文件夹" + directory + " 失败！开始创建文件夹");
        }
        return flag;
    }

    //创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
    public boolean CreateDirecroty(String remote) throws Exception {
        boolean success = true;
        String directory = remote + "/";
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + "/" + subDirectory;
                if (!existFile(path)) {
                    if (makeDirectory(subDirectory)) {
                        changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(subDirectory);
                    }
                } else {
                    changeWorkingDirectory(subDirectory);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    //判断ftp服务器文件是否存在
    public boolean existFile(String path) throws Exception {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }
    //创建目录
    public boolean makeDirectory(String dir) throws Exception{
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("创建文件夹" + dir + " 成功！");

            } else {
                System.out.println("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        return flag;
    }

    /** * 下载文件 *
     * @param pathname FTP服务器文件目录 *
     * @param filename 文件名称 *
     * @param localpath 下载后的文件路径 *
     * @return */
    public  boolean downloadFile(String pathname, String filename, String localpath) throws Exception{
        boolean flag = false;
        try {
            OutputStream os=null;
            System.out.println("开始下载文件");
            initFtpClient();
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for(FTPFile file : ftpFiles){
                if(filename.equalsIgnoreCase(file.getName())){
                    File localFile = new File(localpath + "/" + file.getName());
                    os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(file.getName(), os);
                    os.close();
                }
            }
            ftpClient.logout();
            flag = true;
            System.out.println("下载文件成功");
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /** * 删除文件 *
     * @param pathname FTP服务器保存目录 *
     * @param filename 要删除的文件名称 *
     * @return */
    public boolean deleteFile(String pathname, String filename) throws Exception{
        boolean flag = false;
        try {
            System.out.println("开始删除文件");
            initFtpClient();
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.dele(filename);
            ftpClient.logout();
            flag = true;
            System.out.println("删除文件成功");
        } catch (Exception e) {
            System.out.println("删除文件失败");
            e.printStackTrace();
        }
        return flag;
    }

    public Object show(String fileName) throws Exception {
        String ftpStr = "ftp://"+username+":"+password+"@"+hostname+":"+port+filePath+ fileName;
        URL url = new URL(ftpStr);
        return url;
    }
}
