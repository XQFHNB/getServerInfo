package com.xqf.getInfo.ftp;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

/**
 * 描述:
 * 測試ftp類
 *
 * @author xqf
 * @create 2018-04-16 13:05
 */

public class FTPMain {

    private static Logger logger = Logger.getLogger(FTPMain.class);

    public static void main(String[] args) {
        int ftpPort = 0;
        String ftpUserName = "";
        String ftpPassword = "";
        String ftpHost = "";
        String ftpPath = "";
        String writeTempFielPath = "";
        try {
            InputStream in = FTPUtil.class.getClassLoader().getResourceAsStream("properties/env.properties");
            if (in == null) {
                logger.info("配置文件env.properties读取失败");
            } else {
                Properties properties = new Properties();
                properties.load(in);
                ftpUserName = properties.getProperty("ftpUserName");
                ftpPassword = properties.getProperty("ftpPassword");
                ftpHost = properties.getProperty("ftpHost");
                ftpPort = Integer.valueOf(properties.getProperty("ftpPort"))
                        .intValue();
                ftpPath = properties.getProperty("ftpPath");
                writeTempFielPath = properties.getProperty("writeTempFielPath");

                ReadFTPFile read = new ReadFTPFile();
                String result = read.readConfigFileForFTP(ftpUserName, ftpPassword, ftpPath, ftpHost, ftpPort, "/root/xqf.test");
                System.out.println("读取配置文件结果为：" + result);

                WriteFTPFile write = new WriteFTPFile();
                ftpPath = ftpPath + "/" + "xqf.test";
                write.upload(ftpPath, ftpUserName, ftpPassword, ftpHost, ftpPort, result, writeTempFielPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}