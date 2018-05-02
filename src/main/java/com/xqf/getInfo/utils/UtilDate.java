package com.xqf.getInfo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述:
 * 返回当前时间字符串
 *
 * @author xqf
 * @create 2018-04-17 15:08
 */
public class UtilDate {

    public static String getCurrentTime() {
        Date dNow = new Date();
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");

        return ft.format(dNow);
    }


    public static void main(String[] args) {
        System.out.println(getCurrentTime());
    }
}