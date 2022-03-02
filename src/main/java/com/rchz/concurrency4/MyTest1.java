package com.rchz.concurrency4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest1 {

    /*
        关于Lock与synchronized关键字在锁处理上的重要差别
        1.锁的获取方式：前者是通过程序代码的方式获取锁，后者是通过JVM来实现的（无需开发者干预）
        2.具体实现方式：前者是由Java代码来实现的，后者是通过JVM底层来实现（无需开发者干预）
        3.锁的释放方式：前者务必通过unlock()方法在finally块中释放，后者通过JVM来释放（无需开发者关注）
        4.锁的具体类型：前者提供了多种，如公平锁，非公平锁，后者与前者均提供了可重入锁
     */


    private Lock lock = new ReentrantLock();//可重入锁

    public void myMethod1(){
        try {
            lock.lock();
            System.out.println("myMethod1 invoked");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }

    public void myMethod2(){
        try {
            lock.lock();
            System.out.println("myMethod2 invoked");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
//        boolean result = false;
//        try {
//            result = lock.tryLock(800, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if(result){
//            System.out.println("111");
//        }else{
//            System.out.println("222");
//        }
    }

    public static void main(String[] args) {
        MyTest1 myTest1 = new MyTest1();

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                myTest1.myMethod1();

            }
        });

        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                myTest1.myMethod2();

            }
        });

        thread1.start();
        thread2.start();
    }

}
