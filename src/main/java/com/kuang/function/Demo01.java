package com.kuang.function;

import java.util.function.Function;

/**
 * Function 函数式接口
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-11- 09:48:00
 */
public class Demo01 {

    public static void main(String[] args) {
//        接受一个参数，再返回这个参数
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };

        /**
         * lambda表达式
         * (str) 入参
         *
         */
        Function<String, String> function = (str) -> {
            return str;//返回值
        };

        System.out.println(function.apply("kk"));
    }
}
