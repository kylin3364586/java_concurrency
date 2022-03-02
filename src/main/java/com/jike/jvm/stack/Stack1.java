package com.jike.jvm.stack;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年11月29日 14:27:00
 *
 * 默认情况count：11406
 * 设置栈大小: -Xss128k   count:974
 */
public class Stack1 {

    private static int count = 0;
    public static void main(String[] args) {
        count++;
        System.out.println(count);
        main(args);
    }
}
