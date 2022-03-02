package com.jike.jvm.stack;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年11月30日 10:10:00
 */
public class LocalVariablesTest {

    static int i;
    static Integer in;
    static Long l;

    public static void main(String[] args) {
        LocalVariablesTest local = new LocalVariablesTest();
        int num = 10;
        local.test1();
        System.out.println(i);
        System.out.println(in);
        System.out.println(l);
    }

    public static void testStatic(){
        LocalVariablesTest local = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);

    }

    private void test1() {
        Date date = new Date();
        String name = "kylin";
        String s = test3();
        System.out.println(date + name + s);

    }
    private String test3() {
        Date date = new Date();
        String name = "kylin22";
        System.out.println(date + name);
        return name;
    }
}
