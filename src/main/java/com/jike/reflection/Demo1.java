package com.jike.reflection;

/**
 * Java 反射 dmeo
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月20日 14:42:00
 */
public class Demo1 {

    private String key;
    public void test1(){

    }

    public static void main(String[] args) {
        //获取类字节码的三种方式
        //1 调用 Object 的 getClass 方法
        Demo1 demo1 = new Demo1();
        Class<? extends Demo1> aClass = demo1.getClass();
        //2 调用该类的 class 属性
        Class<Demo1> demo1Class = Demo1.class;
        //3 调用 Class 的 Class.forName() 静态方法
        try {
            Class<?> forName = Class.forName("com.jike.reflection.Demo1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
