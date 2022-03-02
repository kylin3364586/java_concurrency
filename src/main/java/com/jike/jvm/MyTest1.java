package com.jike.jvm;

public class MyTest1 {

    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        int k = i + j;


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");

        ClassLoader classLoader = MyTest1.class.getClassLoader();
        System.out.println(classLoader);

        Class<? extends Class> aClass = MyTest1.class.getClass();
        System.out.println(aClass);
    }

    public int calc(){
        int a = 100;
        int b = 200;
        int c = 300;
        return (a+b)*c;
    }
}
