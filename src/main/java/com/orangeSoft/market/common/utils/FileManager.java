package com.orangeSoft.market.common.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.Objects;

public class FileManager {
    public final static String MAIN_FILE_PATH = "F:/OrangeSoft/NetSuperMarket/projectRepository/";
    public final static String DOWNLOAD_PATH = "http://d3840422t4.wicp.vip/download?fileName=";

    public static String saveFile(MultipartFile file) throws IOException {
        FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
        String fileName = java.net.URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()), "utf-8");
        String newFileName = new Date().getTime() + "." + fileName.replace("/", "");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(MAIN_FILE_PATH + newFileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return DOWNLOAD_PATH + newFileName;
    }

    public static void getFile(String fileName, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        byte[] buff = new byte[1024];

        try (OutputStream outputStream = response.getOutputStream();
             BufferedInputStream bis = new BufferedInputStream(new FileInputStream(MAIN_FILE_PATH + fileName))) {
            int read = bis.read(buff);
            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
