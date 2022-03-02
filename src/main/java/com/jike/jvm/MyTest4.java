package com.jike.jvm;

import sun.misc.Launcher;
import sun.security.ec.SunEC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.Provider;

public class MyTest4 {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {


        //引导类加载器、启动类加载器
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL u: urLs) {
            System.out.println(u.toExternalForm());
        }
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

        //扩展类加载器
        String property = System.getProperty("java.ext.dirs");
        for (String s: property.split(";")) {
            System.out.println(s);
        }
        ClassLoader c = SunEC.class.getClassLoader();
        System.out.println(c);

    }
}
