package com.jike.jvm.string;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月16日 10:19:00
 */
public class StringTest3 {

    private static final int MAX_COUNT = 1000 * 10000;
    static final String[] arr = new String[MAX_COUNT];

    public static void main(String[] args) {
        Integer[] data = new Integer[]{1,2,3,4,5,6,7,8,9,10};

        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_COUNT; i++) {
            arr[i] = new String(String.valueOf(data[i % data.length]));
//            arr[i] = new String(String.valueOf(data[i % data.length])).intern();
        }

        long end = System.currentTimeMillis();
        System.out.println("花费：" + (end - start) + "ms");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
