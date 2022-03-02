package com.jike.jvm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 *
 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @createTime 2021年12月20日 10:02:00
 */
public class HeapOOM {

    byte[] buffer = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();

        int count = 0;
        try {
            while (true){
                list.add(new HeapOOM());
                count++;
            }

        } catch (Exception e){
            System.out.println("添加次数：" + count);
            e.printStackTrace();
        }

    }
}
