package com.jike.jvm.classloader;

import lombok.SneakyThrows;

public class MyTest1 {
    @SneakyThrows
    public static void main(String[] args) {

        //启动类加载器
        ClassLoader classLoader = Class.forName("java.lang.Integer").getClassLoader();
        System.out.println(classLoader);

        //应用类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        //扩展类加载器
        ClassLoader extClassLoader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(extClassLoader);

    }
}
