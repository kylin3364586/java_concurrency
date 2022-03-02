package com.rchz.concurrency5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/*
CountDownLatch 子线程执行完毕后，继续执行主线程
 */
public class MyTest1 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);//计数器值4

        IntStream.range(0, 3).forEach(i -> new Thread(() ->{
            try {
                Thread.sleep(2000);
                System.out.println("子线程执行:"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }).start());

        System.out.println("子线程启动完毕！");

        try {
            //计数器值等于0 countDownLatch.await();继续往下执行
//            countDownLatch.await();

            //防止永远阻塞
            countDownLatch.await(5000, TimeUnit.MILLISECONDS);

            //主线程业务逻辑。。。。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕！");
    }
}
