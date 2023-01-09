package com.kuang.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock+ 多个condition实现精准唤醒 demo
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-05- 17:03:00
 */
public class Test03 {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                task.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                task.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                task.printC();
            }
        },"C").start();
    }
}

class Task{

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int num = 1; //1 A执行  2 B执行  3 C执行

    public void printA(){
        //加锁
        lock.lock();
        try {
            if (num != 1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"AAAA");
            //唤醒它的下一个线程
            num = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放锁
            lock.unlock();
        }
    }

    public void printB(){
        //加锁
        lock.lock();
        try {
            if (num != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"BBBB");
            //唤醒它的下一个线程
            num = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放锁
            lock.unlock();
        }
    }

    public void printC(){
        //加锁
        lock.lock();
        try {
            if (num != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"CCCC");
            //唤醒它的下一个线程
            num = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放锁
            lock.unlock();
        }
    }
}
