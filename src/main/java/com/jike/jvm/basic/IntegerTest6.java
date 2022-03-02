package com.jike.jvm.basic;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年01月05日 14:27:00
 *
 * -XX:AutoBoxCacheMax=200 设置Integer常量值范围
 */
public class IntegerTest6 {

    public static void main(String[] args) {
        Integer x = 5;
        int y = 5;
        System.out.println(x == y);


        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1 == i2);

        Integer i3 = 222;
        Integer i4 = 222;
        System.out.println(i3 == i4);


    }
}
