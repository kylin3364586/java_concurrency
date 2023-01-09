package com.kuang.lock8;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 锁对象 demo
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-05- 17:53:00
 */
public class Test04 {

    /**
     * sendSms，当前锁的是Phone4这个class的模板
     * call，当前锁的是Phone4这个对象
     * 锁的是两个不同对象
     * 先输出 打电话 发短信
     * @param args
     */
    @SneakyThrows
    public static void main(String[] args) {
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();
        new Thread(() -> {
            phone1.sendSms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone2.call();
        }).start();
    }

}

class Phone4 {

    @SneakyThrows
    public static synchronized void sendSms() {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

}
