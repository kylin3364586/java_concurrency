package com.rchz.spring.proxy.factory.func;

public class Test {
    public static void main(String[] args) {

        //工厂方法
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar());

        factory = new BmwFactory();
        System.out.println(factory.getCar());

    }
}
