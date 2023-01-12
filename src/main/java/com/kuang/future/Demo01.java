package com.kuang.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用: CompletableFuture
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-12- 09:21:00
 */
public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //异步任务,无返回结果
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{//有返回结果
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "runAsync()");
//        });
//        System.out.println("111");
//        completableFuture.get();//获取阻塞执行结果


        //异步任务，有返回结果
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "supplyAsync()");
            int a = 10/0;
            return 1024;
        });
//        Integer num = future.get();
//        System.out.println(num);

        /**
         * success、error返回结果处理
         */
        Integer integer = future.whenComplete((t, u) -> {
            System.out.println("t=>" + t);//返回正确的结果
            System.out.println("u=>" + u);//返回异常  java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());//输出错误信息
            return 500;//错误返回结果
        }).get();

        System.out.println(integer);//返回结果，可以获取到错误的返回结果
    }
}
