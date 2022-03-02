package com.rchz.annotation;

public class test {

    @MyTest(min = 2,max = 12)
    static int i = 11;


    @MyTest
    public static boolean check(){
        return false;
    }

    public static void main(String[] args) {

        System.out.println(i);


    }
}
