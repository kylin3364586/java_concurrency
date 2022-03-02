package com.jike.jvm.stack;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 *
 * 未开启逃逸分析 -XX:-DoEscapeAnalysis
 *
 * -Xms1G -Xmx1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * @createTime 2021年12月07日 14:38:00
 */
public class StackAllocation {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();
        System.out.println("花费时间"+ (end - start) +"ms");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void alloc(){
        User user = new User();
    }

    static class User{

    }
}

