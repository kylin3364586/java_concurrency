package com.kuang.pc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock() + unlock() + await() + signalAll()
 * 生产消费者
 *
 * 两个线程交替执行，对一个值加一减一
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-05- 14:51:00
 */
public class Test02 {

    public static void main(String[] args) {
        Date2 date = new Date2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    date.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    date.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    date.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    date.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

//while 防止 虚假唤醒
class Date2 {

    private int num = 0;

    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    //+1
    public void increment() throws InterruptedException {
        lock.lock();//使用lock加锁
        try {
            while (num == 1){
                //等待
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "->" + num);
            //唤醒其他线程
            condition.signalAll();
        } finally {
            lock.unlock();//使用lock解锁
        }

    }

    //-1
    public synchronized void decrement() throws InterruptedException {
        lock.lock();

        try {
            while (num == 0) {
                //等待
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "->" + num);
            //唤醒其他线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
}
