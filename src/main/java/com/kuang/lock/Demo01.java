package com.kuang.lock;

/**
 *
 * Synchronized 可重入锁
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-13- 11:16:00
 */
public class Demo01 {

    private static Phone phone = new Phone();

    public static void main(String[] args) {
        new Thread(()->{
            phone.sms();
        },"a").start();

        new Thread(()->{
            phone.sms();
        },"b").start();
    }

}

class Phone{

    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+" sms");
        call();
    }
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+" call");
    }
}
