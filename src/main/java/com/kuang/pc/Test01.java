package com.kuang.pc;


/**
 * synchronized+ wait()+ notifyAll()
 * 生产消费者
 *
 * 两个线程交替执行，对一个值加一减一
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-05- 14:51:00
 */
public class Test01 {

    public static void main(String[] args) {
        Date date = new Date();
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
class Date {

    private int num = 0;

    //+1
    public synchronized void increment() throws InterruptedException {
        while (num == 1){
            //等待
            this.wait();
        }

        num++;
        System.out.println(Thread.currentThread().getName() + "->" + num);
        //唤醒其他线程
        this.notifyAll();
    }

    //-1
    public synchronized void decrement() throws InterruptedException {
        while (num == 0) {
            //等待
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "->" + num);
        //唤醒其他线程
        this.notifyAll();

    }
}
