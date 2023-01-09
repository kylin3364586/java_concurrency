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
public class Test02 {

    /**
     * 当前锁的是Phone这个对象，有两个不同对象分别调用（分别持有一把锁），先打电话-发短信
     * @param args
     */
    @SneakyThrows
    public static void main(String[] args) {
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(() -> {
            phone1.sendSms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone2.call();
        }).start();
    }

}

class Phone2 {

    @SneakyThrows
    public synchronized void sendSms() {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

}
