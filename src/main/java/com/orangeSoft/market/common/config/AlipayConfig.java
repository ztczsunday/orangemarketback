package com.orangeSoft.market.common.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    public static String appId = "2021000117617252";
    public static String merchantPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCHQ80aBkyiHPEMHUomsgnbvdqvIeyPYE+wpFOouRRMVBvzwFuh0x6eWUYNGagr849xLV5vBw+jLEyLFjmx3BflLUw2zZcEe8f6nbIS/sHxsAYYNca6tDuuvZ1HNh5LS0vXSPWBx1Dp6B++ZmcGPtmgTAEOS6Wg1XDEDnqST7vEeRqFQo2/12H5VgRwXdze7We6xKMpCysVWJzO7W29/NrfjCq5l21djrQy7DO0P6ZiOSVby00vtfwv6qHwQoxPwYD5Qc64JFp0lLKRrE3T37qvdpaOBRmW6E07JBXxWmzOudQA9g2UotlabbGmRXAtPUV7hGzNGEIUgT9ZB/MEp4xTAgMBAAECggEAWqT29y+tfx3B8wpVvKSmspkByUcEjfhOruMQJQsSLSxYJvqK7WDbLeZJaVH+PqXTRFbQ57plokV3beWQ+D2zzaKTZk5Tm2+PzcSLpusN8PayvtqauFc7f5gVo7kCiBaHVlfQHg4BjR4+14ssEyVfFWqZcokDD0q5bMj/HrlL7Rb5YRSDRNwA5cMQR1qqZnT191zrtWBsZ18xyQvmYlknoh4SsucrZpZvUr3SxAcSmBQFJRiqKqsDmqPJ6tLUhLCiMDD9DbW3vwoMozpSCYGy8NI0Tg3nU9TX01+5ys/bxneK3iJZIShIojOpOrAn1igBA2SgT4SNeM8ZHHwf4jSkUQKBgQC8LjYxbKi6RmCH6Q6hyJXkL+SCY3y08cWITY63AzcMi86vRX4uBaScq2QaBQI3ioYW20QmnNol6aI2FTBo3wcVK7K9AZ2yA/QAG+rx0qEasg7+kXhEqu2hHDW+MKM64oY7UybswVI/ux7/YWWVdeUJLXD/9FQ1V0d6B71LcOBT1wKBgQC4A4TJY9iMwjI/h+77qSTtSoeCNVJjfLnuBUV9Lw2btkCzcQ5/NTWRIMs7ARSpODaTerkrDeQuv/NEcqUdpimEgGwNfRr8rUk0fKPAi5TAmDGxGLcArRguVCobZU56hwBr2AQVZElfj+rBP2YSJgoGuli+9C48zycJZD2Pd2Y75QKBgCsdD099jJ641w7sZ2zLjwPrsRfqgTzXk6Ep28O0Wd1m/qCLdGBI7LD0V4fak+pzs0rzS4bpMtWy1HY9noy4ZGAGVfoVr7KEU1ffDZH/5uc92k+atopM+wqJcwqzDALGuWhIIcfmdtihH3X1M5ftnd7faV9K9CwQZhDgSw9IuiybAoGAIZ7S9hC+EgmxMJZffa+LxacmVw3y/aZeOjTQW2zraZXFAIQZh/hqzxdUynUKF1jj79IuXsVs+XWstsbTkDU5xLHKDDTdZ2kpxOM48AcQqJemDJtdZEw77MsH3nWF/zEHTKztIhNurH0ZATHaLlqw3kXRzSHECOw4T6j27m18SlkCgYAJAClijpi44Am9AsbkDRZ3Pg2/51wlXL99gore2GJcGMOluw1VPbzVXJrDCKf/ERv+kgxKDZMBUZOjkf0ZYU8p8CvqBm735Jd+mzZIDye0jvlCbEzsry75FHNUvU8+h8UM74qrbtkd4wEipg191I32tJkuXQgECe8u9EOTswuQmw==";
    public static String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqtrzF5x6R5KwgaVlMMDFIeMdYvpAYpvq9ESMKxdsSYThddKyy9UyKZc8Gvf4quKJiaXZKucA5TUh95cW7budvmx/1JueNG8rL105jsdaL46shJpWpMMIc3au1jMaPgbvwEHJSuROMO6imhcx+t8n7guzCGk3ckk/z8HjQChjMFx9uZCruIDglHr9ZFrEPSLfwu7UNVlP5u7YBmflbRUKgor1fSy2wWwwyGeZz5qtbOKOouGLkxF9czGSj5I6puw36/FCnk0kMSYTBldoi64JV5ReShYWTiH45+kQwX58kXz/4y9ix16hR/sjEKOtgu0QbigQ1lGih1EA4vqb+vVxeQIDAQAB";
    public static String notifyUrl = "http://d3840422t4.wicp.vip/AlipayReturn";
    public static String returnUrl = "http://d3840422t4.wicp.vip/index.html#/PayReturn";
    //    public static String returnUrl = "http://d3840422t4.wicp.vip/test";
    public static String signType = "RSA2";
    public static String charset = "utf-8";
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    public static String logPath = "C:\\";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(logPath + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
