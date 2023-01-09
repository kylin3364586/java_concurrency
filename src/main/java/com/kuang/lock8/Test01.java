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
public class Test01 {

    /**
     * 当前锁的是Phone这个对象，全局只有一把锁，当sendSms持有锁后，需要其执行完，才能继续执行call
     * @param args
     */
    @SneakyThrows
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone.call();
        }).start();
    }

}

class Phone {

    @SneakyThrows
    public synchronized void sendSms() {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

}
