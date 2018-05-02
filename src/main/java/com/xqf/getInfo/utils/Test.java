package com.xqf.getInfo.utils;

/**
 * 描述:
 *
 * @author xqf
 * @create 2018-04-17 19:27
 */
public class Test {
    public static String helpTransfor(String str) {
        return str.replaceAll("\\\\", "\\\\\\\\");
    }

    public static void main(String[] args) {
//        String str = "\"dh\\dhhd\"";
//        System.out.println(str);
//
//        System.out.println("123\\".replace("\\", "\\\\"));

        System.out.printf(helpTransfor("123\\"));
    }

}