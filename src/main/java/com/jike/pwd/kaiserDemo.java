package com.jike.pwd;

import org.junit.jupiter.api.Test;

/**
 *
 * 恺撒加密
 * 位移法
 * 原理：将26个字母往左（右）位移,1-25位
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年04月26日 11:11:00
 */
public class kaiserDemo {



    public static void main(String[] args) {
        String str = "Hello World";

        String encrypt = encrypt(str, 3);
        System.out.println("加密："+encrypt);


        String decrypt = encrypt(encrypt, -3);
        System.out.println("解密："+decrypt);

    }

    /**
     * 恺撒加解密
     * @param str 字符串
     * @param key 偏移量
     */
    @Test
    public static String encrypt(String str, int key) {
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char aChar : chars) {
            int index = aChar;
            char result = (char)(index + key);
            sb.append(result);
        }
        return sb.toString();
    }


}
