package com.kuang.tvolatile;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * volatile:
 * 1.保证可见性
 * 2.不保证原子性
 * 3.禁止指令重排
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-12- 13:51:00
 */
public class JMMDemo {

    /**
     * 1.volatile保证可见性
     */
    private volatile static int num = 0;//定义主内存中的值
    @SneakyThrows
    public static void main(String[] args) {//main 线程

        new Thread(()->{//自定义线程，对主内存中值的变化是不知道的
            while ( num == 0){

            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        num = 1;//修改主内存中的值
        System.out.println(num);

    }
}
