package com.rchz.concurrency8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 *  对于ReentrantLook来说，执行逻辑如下：
 *      1.尝试获取对象的锁，如果获取不到（意味着已经有其他线程持有了锁，并且尚未释放），那么他会进入到AQS的阻塞队列当中。
 *      2.如果获取到锁，会根据是公平锁还是非公平锁做不同处理
 *          2.1指定为公平锁，那么线程会放置到AQS阻塞队列的末尾进行排队。
 *          2.2指定为非公平所，那么线程首先会先尝试进行CAS计算，如果成功，则直接获取到锁；如果失败则放置到阻塞队列末尾
 *      3.当锁被释放时（调用了unlock方法），那么底层会调用release方法对state成员变量值减一操作，如果减一后，state值不为0，那么release操作执行完毕；
 *      减一后，如果state值为0，则调用LockSupport的unpark方法，唤醒该线程后等待队列中的第一个后继线程（通过C++的pthread_mutex_unlock指令）,将其唤醒，使之能够获取到
 *      对象的锁（release时，对于公平锁非公平锁处理逻辑是一致的）；之所以调用release后state值可能不为0，原因在于ReentrantLook是可重入锁，同一线程可多次调用lock方法，
 *      导致每调用一次state值就会加一。
 *
 *  对于ReentrantLook来说，所谓的上锁，本质就是对AQS {@link java.util.concurrent.locks.AbstractQueuedSynchronizer} 中的state成员变量的操作，
 *  对该成员变量+1，表示上锁；对该成员变量-1，表示解锁。
 *

 *
 */
public class MyTest1 {

    private Lock lock = new ReentrantLock();

    public void method1(){

        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("sout,method");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        MyTest1 myTest1 = new MyTest1();

        IntStream.range(0, 10).forEach( i -> {
            new Thread(() -> {
                myTest1.method1();
            }).start();
        });
    }
}
