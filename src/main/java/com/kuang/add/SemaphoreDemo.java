package com.kuang.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-06- 17:02:00
 */
public class SemaphoreDemo {
    public static void main(String[] args) {

        //定义信号量
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//获得，假设如果已经满了，等待，等待被释放为止！
                    System.out.println(Thread.currentThread().getName()+"抢到车位");

                    //模拟业务处理
                    TimeUnit.SECONDS.sleep(2);//睡眠2秒

                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();//释放，将当前信号量释放！信号量+1，唤醒等待的线程
                }
            },String.valueOf(i)).start();
        }
    }
}
