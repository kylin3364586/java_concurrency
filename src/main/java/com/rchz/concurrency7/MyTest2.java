package com.rchz.concurrency7;

import java.util.concurrent.CompletableFuture;

public class MyTest2 {

    public static void main(String[] args) throws Exception {

        //返回结果
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApplyAsync(value -> value + " world").join();
        System.out.println(result);

        //消费结果
        CompletableFuture.supplyAsync(() -> "hello").thenAccept(value -> System.out.println("welcome " + value));

        String result2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();

        System.out.println(result2);
    }
}
