package com.jike.jvm.string;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月15日 15:53:00
 */
public class StringTest2 {

    public static void main(String[] args) {


        String str = new String("1");//，创建两个对象，（一个是堆中的1，另一个是常量池中的1）；返回的是堆中的1
        String intern = str.intern();//返回堆中常量池中的1


        String str2 = "1";//对象值是放在堆中常量池中的
        System.out.println(str == str2);// false
        System.out.println(intern == str2);// true


        //在堆中创建一个11的对象
        String s3 = new String("1") + new String("1");
        //在常量池中创建11，首先在常量池中寻找没有11，接着去堆中寻找发现堆中已经有11了，出于节约空间的原则，便在常量池中创建了一个引用然后指向堆中的11
        s3.intern();
        //在常量池中创建11，发现常量池中已经存在11这个值（只不过是一个引用），便使当前指向常量池中11的这个引用
        String s4 = "11";
        System.out.println(s3 == s4); // true


        //堆中
        String s5 = new String("1") + new String("1");
        //堆中的常量池中
        String s6 = "11";
        String intern1 = s5.intern();
        System.out.println(s5 == s6); // false
        System.out.println(intern1 == s6); // true

    }
}
