package com.kuang.unsafe;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-05- 18:51:00
 */
public class ListTest {

    public static void main(String[] args) {

        /**
         * ArrayList在并发场景下是不安全的，ConcurrentModificationException：并发修改异常
         * 解决方案:
         * 1.List<String> list = new Vector<>();
         * 2.List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3.List<String> list = new CopyOnWriteArrayList<>();
         */
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

            for (int i = 1; i < 10; i++) {
                new Thread(()->{
                    list.add(UUID.randomUUID().toString().substring(0,5));
                    System.out.println(list);
                }).start();
            }


    }
}
