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
public class Test03 {

    /**
     * static方法，当前锁的是Phone3这个class的模板，全局只有一把锁，
     * 先输出 发短信- 打电话
     * @param args
     */
    @SneakyThrows
    public static void main(String[] args) {
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();
        new Thread(() -> {
            phone1.sendSms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone2.call();
        }).start();
    }

}

class Phone3 {

    @SneakyThrows
    public static synchronized void sendSms() {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }

}
