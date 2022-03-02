package com.rchz.concurrency5;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/*
CyclicBarrier 屏障，每个线程执行到 cyclicBarrier.await(); 都会进入阻塞状态
              当所有线程（最后一个线程）都执行到cyclicBarrier.await();时，屏障取消（停直阻塞）所有线程继续往下执行

              关于CyclicBarrier底层执行流程
              1.初始化CyclicBarrier个中成员变量，包括parties、count以及Runnable(可选)
              2.当调用await方法时，先检查计数器是否归零，如果是则执行可选得Runnable，接下来开始下一个Generation;
              3.在下一个分代中，将会重置count值为parties，并且创建新得Generation实例。
              4.同时会调用Condition得signalAll()方法，唤醒所有在屏障前面等待得线程，让其开始继续执行。
              5.如果计数器没有归零，那么当前线程会调用Condition得await方法，使当前线程再屏障前等待。
              6.以上所有流程均在lock锁内执行，不会出现并发情况。
 */

public class MyTest2 {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () ->{
            System.out.println("hello world");
        });

        for (int i = 0; i < 2; ++i) {
            for(int n = 0; n < 3; ++n){
                new Thread(() -> {
                    try {
                        Thread.sleep((long) (Math.random()*2000));

                        int random = new Random().nextInt(500);

                        System.out.println("hello " + random);

                        cyclicBarrier.await();

                        System.out.println("world " + random);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
