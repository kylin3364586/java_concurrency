package com.kuang.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-10- 11:37:00
 */
public class MyExecutors {


    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newSingleThreadExecutor();//单一线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(5);//固定大小线程池
        ExecutorService executorService = Executors.newCachedThreadPool();//缓存线程池，可伸缩
        for (int i = 0; i < 100; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+" ok");
            });
        }

        executorService.shutdown();
    }

}
