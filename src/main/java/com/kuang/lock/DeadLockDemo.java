package com.kuang.lock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-13- 13:58:00
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        //T1线程持有lockA等待获取lockB
        new Thread(new MyThread(lockA, lockB),"T1").start();
        //T2线程持有lockB等待获取lockA
        new Thread(new MyThread(lockB, lockA),"T2").start();
    }
}


class MyThread implements Runnable {

    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " is lockA =》 get lockB");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " is lockB =》 get lockA");
            }
        }
    }

}
