package com.jike.jvm.heap;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 *
 * 设置初始、最大堆大小
 * -Xms800m -Xmx800m
 *    查看设置参数：
 *      方式一： jps  /  jstat -gc 进程id
 *      方式二： -XX:+PrintGCDetails
 * @createTime 2021年12月06日 09:22:00
 */
public class HeapSpaceInitial {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory()/1024 /1024;
        long maxMemory = runtime.maxMemory()/1024 /1024;

        //M
        System.out.println("-Xms:"+totalMemory);
        System.out.println("-Xmx:"+maxMemory);

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
