package com.kuang.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 可重入锁
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-13- 11:19:00
 */
public class Demo02 {


    private static Phone2 phone = new Phone2();

    public static void main(String[] args) {
        new Thread(()->{
            phone.sms();
        },"a").start();

        new Thread(()->{
            phone.sms();
        },"b").start();
    }

}

class Phone2{
    Lock lock = new ReentrantLock();//可重入锁，所必须配对
    public void sms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
