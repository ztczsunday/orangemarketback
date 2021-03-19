package com.orangeSoft.market.common.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.Objects;

public class FileManager {
    private final static String MAINFILEPATH = "F:/OrangeSoft/NetSuperMarket/projectRepository/";

    public static String saveFile(MultipartFile file) throws IOException {
        FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
        String fileName = java.net.URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()), "utf-8");
        String newFileName = new Date().getTime() + "." + fileName.replace("/", "");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(MAINFILEPATH + newFileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return newFileName;
    }

    public static Result.JSONResultMap getFile(String fileName, HttpServletResponse response) {
        File file = new File(MAINFILEPATH + fileName);
        if (!file.exists()) {
            return Result.fail(null, "喔唷,找不到文件,可能是文件不存在");
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName.split("/")[1]);
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();

            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File(MAINFILEPATH + fileName)));
            int read = bis.read(buff);
            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Result.success();
    }
}
