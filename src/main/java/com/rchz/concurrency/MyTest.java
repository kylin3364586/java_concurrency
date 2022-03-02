package com.rchz.concurrency;

/**
 * @Author kylin
 * @Description
 *  调用wait()方法时，线程必须持有当前对象的锁。synchronized(obj)
 *  调用当前对象的wait()会放弃当前对象持有的锁，调用sleep()不会放弃当前对象持有的锁
 *
 * @Date 9:59 2020/7/1
 **/
public class MyTest {


    public static void main(String[] args) throws InterruptedException {
//        Object obj = new Object();
//        synchronized (obj){
//            obj.wait();
//        }
        //--------------------------------------------------------------
        MyObject object = new MyObject();
        Thread t1 = new ThreadA(object);
        Thread t2 = new ThreadB(object);
        Thread t3 = new ThreadA(object);
        Thread t4 = new ThreadB(object);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }



}