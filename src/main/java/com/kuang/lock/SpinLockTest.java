package com.kuang.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-13- 11:36:00
 */
public class SpinLockTest {

    @SneakyThrows
    public static void main(String[] args) {
        //底层使用CAS
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinLockDemo.myUnLock();
            }
        },"a").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinLockDemo.myUnLock();
            }
        },"b").start();
    }
}
