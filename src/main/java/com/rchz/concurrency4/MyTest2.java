package com.rchz.concurrency4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/*
    传统上，我们可以通过synchronized关键字 + wait + notify/notifyAll来实现多个线程之间的协调与通信，整个过程都是由JVM来帮我们实现的，
    开发者无需（也无法）了解底层实现细节，除非翻看jdk源码。

    JDK1.5开始，由并发包Lock，Condition(await与signal/signalAll)来实现多个线程之间的协调与通信，整个过程都是由开发者来控制，
    而且相比传统方式，更加灵活，也更加强大。

    Thread.sleep与await（或者是Object的wait方法）的本质区别是：sleep不会释放掉锁，而await会释放锁，并且在signal之后，还需要
    重新获得锁才能继续执行（该行为与Object的wait方法完全一致）
 */
public class MyTest2 {

    public static void main(String[] args) {
        BoundedContainer boundedContainer = new BoundedContainer();

        IntStream.range(0,8).forEach( i -> new Thread( () -> {
            try {
                boundedContainer.put("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());

        IntStream.range(0,10).forEach( i -> new Thread( () -> {
            try {
                boundedContainer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
    }
}

class BoundedContainer{

    private String[] elements = new String[10];

    private Lock lock = new ReentrantLock();

    private Condition notEmptyCondition = lock.newCondition();

    private Condition notFullCondition = lock.newCondition();

    private int elementCount;//elements中已有的元素数量

    private int putIndex;

    private int takeIndex;

    public void put(String str) throws InterruptedException {
        lock.lock();//加锁
        try {
            while (elementCount == elements.length){
                notFullCondition.await();//等待
            }
            elements[putIndex] = str;
            if(++putIndex == elements.length){
                putIndex = 0;
            }
            ++elementCount;
            System.out.println("put元素"+ Arrays.toString(elements));
            notEmptyCondition.signal();
        }finally {
            lock.unlock();
        }


    }

    public String take() throws InterruptedException {
        lock.lock();
        try {
            while (elementCount == 0){
//                System.out.println("元素已空");
                notEmptyCondition.await();
            }
            elements[takeIndex] = null  ;
            if(++takeIndex == elements.length){
                takeIndex = 0;
            }
            --elementCount;
            System.out.println("take元素"+ Arrays.toString(elements));
            notFullCondition.signal();
        }finally {
            lock.unlock();
        }
        return null;
    }


}
