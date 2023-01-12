package com.kuang.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-12- 14:10:00
 */
public class VDemo02 {

    /**
     * 2.volatile不保证原子性
     */
    private volatile static int num = 0;
    public static void add (){
        num++;
    }

    //原子类AtomicInteger
//    private static AtomicInteger atomicInteger = new AtomicInteger();
//    public static void add (){
//        atomicInteger.getAndIncrement();
//    }

   /*
   启动20个线程分别调用1000次add()
    */
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2){// main  gc
            Thread.yield();//当前线程放弃对处理器的占用
        }

//        System.out.println(Thread.currentThread().getName() + " " +atomicInteger.get());//理论结果应该是20000
        System.out.println(Thread.currentThread().getName() + " " +num);//理论结果应该是20000
    }

}
