package com.kuang.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 可取消的异步任务
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-06- 11:10:00
 */
public class CallableTest {

    /**
     * 两个线程,只打印一次call()方法，说明此处有缓存
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        Object o = futureTask.get();//可能会阻塞，等待结果
        System.out.println(o);
    }
}

class MyThread implements Callable<String> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        System.out.println("call()调用");
        return "1024";
    }
}
