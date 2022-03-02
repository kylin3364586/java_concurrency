package com.rchz.concurrency8;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class MyTest2 {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void method(){
        try {
            readWriteLock.writeLock().lock();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method");
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        IntStream.range(0, 10).forEach( i -> new Thread(myTest2::method).start());
    }
}
