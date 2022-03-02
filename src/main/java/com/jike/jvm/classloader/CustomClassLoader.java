package com.jike.jvm.classloader;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader {

    @SneakyThrows
    @Override
    protected Class<?> findClass(String name) {
        byte[] classFromCustomPath = getClassFromCustomPath(name);
        if(null == classFromCustomPath){
            throw new ClassNotFoundException();
        }else{
            return defineClass(name, classFromCustomPath, 0, classFromCustomPath.length);
        }
    }

    //根据类名查询byte
    private static byte[] getClassFromCustomPath(String name) throws IOException {
        File file = new File(name);
        byte[] bytes = new byte[(int) file.length()];
        new FileInputStream(file).read(bytes);
        return bytes;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Class<?> myClass = new CustomClassLoader().findClass("com.jike.jvm.classloader.MyClass");
        MyClass myClass1 = (MyClass) myClass.newInstance();
        System.out.println(myClass1.toString());

    }
}
