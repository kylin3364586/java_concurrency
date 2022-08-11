package com.jike.demo;


import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 创建两个线程 将connter中的 count 依次 +1 -1 最终输出 10101010...
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月09日 16:45:00
 */
public class MyThread {

    static Connter connter = new Connter();
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }
    static Runnable runnable1 = new Runnable() {
        @SneakyThrows
        @Override
        public void run() {
            while (true){
                Thread.sleep(500);
                if(connter.getCount() == 0){
                    connter.setCount(connter.getCount() + 1);
                    System.out.println(connter.toString());
                }else{

                }

            }

        }
    };
    static Runnable runnable2 = new Runnable() {
        @SneakyThrows
        @Override
        public void run() {
           while (true){
               Thread.sleep(500);
               if(connter.getCount() == 1){
                   connter.setCount(connter.getCount() - 1);
                   System.out.println(connter.toString());
               }else{

               }

           }
        }
    };
}
