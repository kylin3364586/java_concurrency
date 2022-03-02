package com.jike.jvm;

public class MyTest2 {

    private static int num = 1;


    static {
        num = 2;
        number = 20;
    }

    private static int number = 10;

    public MyTest2(){

    }

    public static void main(String[] args) {
        System.out.println(MyTest2.num);
    }
}
