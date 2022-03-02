package com.jike.jvm.string;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月17日 17:12:00
 */
public class GCRootTest {

    public static void main(String[] args) {
        List<Object> obj = new ArrayList<>();
        Date birth = new Date();

        for (int i = 0; i < 100; i++) {
            obj.add(String.valueOf(i));

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("数据添加完毕：");
        new Scanner(System.in).next();

        obj = null;
        birth = null;

        System.out.println("数据清空：");
        new Scanner(System.in).next();

        System.out.println("结束");
    }
}
