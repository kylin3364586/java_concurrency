package com.jike.jvm.string;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月15日 13:56:00
 */
public class StringTest1 {

    public static void main(String[] args) {
        String s = new StringBuilder().append("a").append("b").toString();

        String s1 = "a" + "b";
        System.out.println(s == s1);
    }
}
