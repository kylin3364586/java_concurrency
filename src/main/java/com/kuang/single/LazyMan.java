package com.kuang.single;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

/**
 * 单例模式：懒汉式
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-12- 16:26:00
 */
public class LazyMan {

    //无参构造私有化，防止外部创建对象
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+ "  ok");
    }

    private volatile static LazyMan lazyMan;

    //双重检测锁模式的懒汉式, 简称DCL懒汉式
    public static LazyMan getInstance(){
        if(null == lazyMan){//双重检测
            synchronized (LazyMan.class){//加锁，避免多线程下重复创建
                if(null == lazyMan){
                    lazyMan = new LazyMan();//不是一个是原子操作，可能会导致指令重排。声明变量时候需要加volatile
                }
            }
        }

        return lazyMan;
    }

    //通过反射破坏单例
    @SneakyThrows
    public static void main(String[] args) {
        LazyMan instance1 = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);//破坏私有权限
        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }

    //并发下有问题
//    public static void main(String[] args) {
//        for (int i = 0; i < 10000; i++) {
//            new Thread(()->{
//                LazyMan.getInstance();
//            }).start();
//        }
//    }
}
