package com.jike.jvm.heap;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * 设置堆大小
 *      -Xms初始堆
 *      -Xmx最大堆
 * @createTime 2021年12月02日 14:44:00
 */
public class HeapDemo1 {

    public static void main(String[] args) {
        System.out.println("start..");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end..");
    }
}
