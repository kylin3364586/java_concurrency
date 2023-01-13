package com.kuang.cas;

import lombok.SneakyThrows;
import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ASC: CompareAndSet 比较交换
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-13- 09:24:00
 */
public class CASDemo {

    @SneakyThrows
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2022);

        // 期望值，更新
        System.out.println(atomicInteger.compareAndSet(2022, 2023));
        System.out.println(atomicInteger.get());

        atomicInteger.getAndIncrement();//以原子的方式+1
        System.out.println(atomicInteger.compareAndSet(2022, 2023));
        System.out.println(atomicInteger.get());

    }
}
