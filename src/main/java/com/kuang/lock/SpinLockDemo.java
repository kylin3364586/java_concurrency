package com.kuang.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自定义 自旋锁
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-13- 11:31:00
 */
public class SpinLockDemo {

    //thread 默认是null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();


    /**
     * 加锁 自旋
     */
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"  myLock");
        while (!atomicReference.compareAndSet(null, thread)){

        }
    }

    /**
     * 解锁
     */
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"  myUnLock");
        atomicReference.compareAndSet(thread, null);
    }
}
