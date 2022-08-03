package com.jike.jvm.classloader;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年03月21日 09:09:00
 */
public class ClassLoaderTest1 {

    public static void main(String[] args) {
        //系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@7b23ec81

        //引导类加载器
        ClassLoader bootStrapClassLoader = extClassLoader.getParent();
        System.out.println(bootStrapClassLoader);//null



        //使用的引导类加载器
        try {
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //自定义类使用系统类加载器
        try {
            ClassLoader classLoader1 = Class.forName("com.jike.jvm.classloader.ClassLoaderTest1").getClassLoader();
            System.out.println(classLoader1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //使用的引导类加载器
        String[] arr = new String[10];
        System.out.println(arr.getClass().getClassLoader());

        //自定义类型数组使用系统类加载器
        ClassLoaderTest1[] clt = new ClassLoaderTest1[10];
        System.out.println(clt.getClass().getClassLoader());

        //基本数据类型不需要加载，也是null
        int[] i = new int[10];
        System.out.println(i.getClass().getClassLoader());

        //获取当前线程上下文classLoader
        System.out.println(Thread.currentThread().getContextClassLoader());

    }
}
