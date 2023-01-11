package com.kuang.forkjoin;

import lombok.SneakyThrows;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-11- 15:13:00
 */
public class Test {
    public static void main(String[] args) {
//        test1(0L, 10_0000_0000L);//325
//        test2(0L, 10_0000_0000L);//260
        test3(0L, 10_0000_0000L);//187
    }

    /**
     * 原始方式，慢
     */
    public static void test1(Long start, Long end){
        long startTime = System.currentTimeMillis();

        long num = 0L;
        for (long i = start; i <= end; i++) {
            num+=i;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("num="+num+" time:"+ (endTime - startTime));
    }

    /**
     * forkJoin方式，稍快
     */
    @SneakyThrows
    public static void test2(Long start, Long end){
        long startTime = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(start, end);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);
        Long num = submit.get();

        long endTime = System.currentTimeMillis();
        System.out.println("num="+num+" time:"+ (endTime - startTime));
    }

    /**
     * stream流方式，最快
     * @param start
     * @param end
     */
    public static void test3(Long start, Long end){
        long startTime = System.currentTimeMillis();
        //并行流
        long sum = LongStream.range(start, end).parallel().reduce(0,Long::sum);

        long endTime = System.currentTimeMillis();
        System.out.println("num="+sum+" time:"+ (endTime - startTime));
    }
}
