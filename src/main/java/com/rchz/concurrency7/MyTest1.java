package com.rchz.concurrency7;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/*
    Future
 */
public class MyTest1 {
    public static void main(String[] args) throws Exception {

        Callable<Integer> callable = () ->{
            System.out.println("per");

            Thread.sleep(2000);

            int random = new Random().nextInt(500);

            System.out.println("post");

            return random;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
//        futureTask.run();
        new Thread(futureTask).start();

//        Integer integer = futureTask.get();
        Integer integer = futureTask.get(1, TimeUnit.MILLISECONDS);

        System.out.println(integer);
    }
}
