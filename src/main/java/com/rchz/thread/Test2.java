package com.rchz.thread;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-03-08- 18:45:00
 */
public class Test2 {


    @Test
    public void t1() throws InterruptedException {
        T1 t1 = new T1();
        Thread thread = new Thread(t1);
        thread.start();
        Thread.sleep(10000);
    }

    @Test
    public void t2(){
        Thread thread = new Thread(new T2());
        thread.start();
    }

    @SneakyThrows
    @Test
    public void t3(){
        T3 t3 = new T3();
        FutureTask<String> futureTask = new FutureTask<>(t3);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }



}

class T3 implements Callable<String>{


    @Override
    public String call() throws Exception {
        return "t33333";
    }
}
class T2 implements Runnable{

    @Override
    public void run() {
        System.out.println("t2222");
    }
}
class T1 extends Thread{
    @SneakyThrows
    @Override
    public void run() {
        System.out.println("t1111");
        Thread.sleep(5000);
        System.out.println(2222);
    }
}
