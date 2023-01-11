package com.kuang.function;

import java.util.function.Consumer;

/**
 * Consumer 消费型接口，接受一个参数，没有返回值
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-11- 10:08:00
 */
public class Demo03 {
    public static void main(String[] args) {
        //打印字符串
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };

        Consumer<String> consumer =str -> { System.out.println(str); };

        consumer.accept("kk");
    }
}
