package com.kuang.function;

import java.util.function.Supplier;

/**
 * 供给型接口：   没有参数，有一个返回值
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-11- 10:18:00
 */
public class Demo04 {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "输出结果";
//            }
//        };

        Supplier<String> supplier =()->{
          return "输出lambda";
        };

        System.out.println(supplier.get());
    }
}
