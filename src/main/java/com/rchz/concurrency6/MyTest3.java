package com.rchz.concurrency6;

import java.util.concurrent.*;

/*
异步任务
    Runnable 无返回结果
    Callable 有返回结果
    get 方法执行未结束会阻塞，直到方法执行完毕
 */
public class MyTest3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(4, 8, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

        Runnable runnable = () -> printA();
        Future<?> submit = executorService.submit(runnable);
        submit.get();

        Callable<String> runnable1 = () -> printB();
        Callable<String> runnable2 = () -> printC();
        Future<String> submit1 = executorService.submit(runnable1);
        Future<String> submit2 = executorService.submit(runnable2);

        //通过get获取执行结果
        System.out.println(submit1.get());
        System.out.println(submit2.get());
    }
    
    public static void printA(){
        System.out.println("A");
    }
    public static String printB() throws InterruptedException {
        Thread.sleep(2000);
        return "B";
    }
    public static String printC(){
        return "C";
    }
}
