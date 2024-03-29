package com.kuang.function;

import java.util.function.Predicate;

/**
 * 断定型接口：有一个输入参数，返回布尔值
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-11- 09:59:00
 */
public class Demo02 {

    public static void main(String[] args) {
        //判断字符串是否为空
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };

        Predicate<String> predicate = str -> { return str.isEmpty(); };

        System.out.println(predicate.test("kk"));
    }
}
