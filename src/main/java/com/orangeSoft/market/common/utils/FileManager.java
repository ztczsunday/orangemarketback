package com.orangeSoft.market.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

public class FileManager {
    private final static String MAINFILEPATH = "F:/OrangeSoft/NetSuperMarket/projectRepository";

    public static String saveFile(MultipartFile file, String filePath) throws IOException {
        File localFile = new File(MAINFILEPATH + filePath);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
        String fileName = java.net.URLEncoder.encode(file.getOriginalFilename(), "utf-8");
        String newFileName = new Date().getTime() + "." + fileName;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath + File.separator + newFileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return newFileName;
    }
}
