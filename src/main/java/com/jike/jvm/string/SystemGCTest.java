package com.jike.jvm.string;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月22日 11:39:00
 */
public class SystemGCTest {

    public static void main(String[] args) {
        new SystemGCTest();

        System.gc();

        System.runFinalization();//强制调用finalize()方法
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("在输出代表GC执行了");
    }
}
