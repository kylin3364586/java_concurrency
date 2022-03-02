package com.jike.jvm;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月08日 14:29:00
 */
public class MyTest5 {

    public static void main(String[] args) {
        Long l =    99999999L;
        Integer i = 99999999;
        long l1 = i.longValue();
        System.out.println(l.equals(l1));

        try {
            MyTest5 myTest5 = MyTest5.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(14%7);

    }


}
