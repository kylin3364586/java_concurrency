package com.kuang.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程操作同一个资源
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-05- 13:47:00
 */
public class SaleTicketDemo02 {

    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(() -> {for (int i = 0; i < 40; i++)ticket.sale();}, "A").start();
        new Thread(() -> {for (int i = 0; i < 40; i++)ticket.sale();}, "B").start();
        new Thread(() -> {for (int i = 0; i < 40; i++)ticket.sale();}, "C").start();

    }

}

//1. 创建锁 new ReentrantLock();
//2. 在业务执行前加锁 lock.lock();
//3. 在finally中释放锁 lock.unlock();
class Ticket2 {
    //属性
    private int num = 30;
    Lock lock = new ReentrantLock();
    //方法
    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了：" + num-- + "张票，剩余：" + num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}


