package com.kuang.single;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 单例模式：懒汉式
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-12- 16:26:00
 */
public class LazyMan2 {

    //定义一个属性，判断对象是否可以创建
    private static boolean keys = false;

    //无参构造私有化，防止外部创建对象
    private LazyMan2(){
        synchronized (LazyMan2.class){
            if(false == keys){
                keys = true;
            }else{
                throw new RuntimeException("防止反射破坏单例");
            }
        }
        System.out.println(Thread.currentThread().getName()+ "  ok");
    }

    private volatile static LazyMan2 lazyMan;

    //双重检测锁模式的懒汉式, 简称DCL懒汉式
    public static LazyMan2 getInstance(){
        if(null == lazyMan){//双重检测
            synchronized (LazyMan2.class){//加锁，避免多线程下重复创建
                if(null == lazyMan){
                    lazyMan = new LazyMan2();//不是一个是原子操作，可能会导致指令重排。声明变量时候需要加volatile
                }
            }
        }

        return lazyMan;
    }

    //通过反射破坏单例
    @SneakyThrows
    public static void main(String[] args) {
        Field field = LazyMan2.class.getDeclaredField("keys");
        field.setAccessible(true);

        Constructor<LazyMan2> declaredConstructor = LazyMan2.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);//破坏私有权限
        LazyMan2 instance1 = declaredConstructor.newInstance();

        field.set(instance1,false);

        LazyMan2 instance2 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }

}
