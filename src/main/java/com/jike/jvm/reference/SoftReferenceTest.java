package com.jike.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月23日 14:24:00
 */
public class SoftReferenceTest {

    /**
     * 软引用
     * 当对象只被弱引用关联，即将发生内存溢出时，会把这些对象列入回收范畴内，内存不足时则回收
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        SoftReferenceTest softReference = new SoftReferenceTest();
        SoftReference<SoftReferenceTest> sf = new SoftReference(softReference);
        softReference = null;

        System.out.println("GC之前："+sf.get());

        System.gc();

        try {
            Byte[] bytes = new Byte[1024 * 7168 - 1024 * 1004];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("GC之后："+sf.get());
        }

    }
}
