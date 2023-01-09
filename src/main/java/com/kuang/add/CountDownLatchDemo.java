package com.kuang.add;


import java.util.concurrent.CountDownLatch;

/**
 * 减法计数器
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-06- 16:09:00
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() +"  go out ");
                countDownLatch.countDown();//计数器-1
            }).start();
        }
        countDownLatch.await();//等待计数器归0，继续往下执行
        System.out.println("close door");
    }
}
