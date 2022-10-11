package com.rchz.thread;

/**
 * synchronized+wait+notify
 * 实现：三个线程按序打印ABC
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月09日 11:30:00
 */
public class Demo1 {

    public static void main(String[] args) {
        new Thread(()->{
            ABC.printA();
        },"A").start();
        new Thread(()->{
            try {
                ABC.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                ABC.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();
    }
}

class ABC{
    private final static Object lock = new Object();
    //A 是否已经执行
    private static Boolean aExecute = false;
    //B 是否已经执行
    private static Boolean bExecute = false;

    public static void printA(){
        synchronized (lock){
            System.out.println("A");
            lock.notifyAll();
            aExecute = true;
        }

    }

    public static void printB() throws InterruptedException {
        synchronized (lock){
            //轮询阻塞，需要A执行完成
            while (!aExecute){
                lock.wait();
            }
            System.out.println("B");
            lock.notifyAll();
            bExecute = true;
        }
    }

    public static void printC() throws InterruptedException {
        synchronized (lock){
            //轮询阻塞，需要B执行完成
            while (!bExecute){
                lock.wait();
            }
            System.out.println("C");
            lock.notifyAll();
        }
    }

}
