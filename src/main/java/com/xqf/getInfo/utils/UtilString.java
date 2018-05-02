package com.xqf.getInfo.utils;

/**
 * 描述:
 * 关于字符串操作的工具类
 *
 * @author xqf
 * @create 2018-04-18 14:15
 */
public class UtilString {

    /**
     * 将\变更成\\,在盘符那里有用
     *
     * @param str
     * @return
     */
    public static String helpTransfor(String str) {
        return str.replaceAll("\\\\", "\\\\\\\\");
    }

}