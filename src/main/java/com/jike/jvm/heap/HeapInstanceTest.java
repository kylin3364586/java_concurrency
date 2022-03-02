package com.jike.jvm.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月06日 13:39:00
 */
public class HeapInstanceTest {

    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) {
        List<HeapInstanceTest> list = new ArrayList<>();
        while (true){
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
