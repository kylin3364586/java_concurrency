package com.rchz.spring.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author kylin
 * @Description // jdk 代理
 * @Date 15:53 2020/8/17
 **/
public class TestFindLove {
    public static void main(String[] args) throws IOException {
//        new Zhangsan().findLove();

        Person instance = (Person) new Meipo().getInstance(new Zhangsan());
        instance.findLove();
        System.out.println(instance.getClass());

        //获取字节码
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{instance.getClass()});
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D://$Proxy0.class"));
        fileOutputStream.write($Proxy0s);
        fileOutputStream.close();
    }

}
