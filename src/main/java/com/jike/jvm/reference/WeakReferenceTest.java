package com.jike.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月23日 17:30:00
 */
public class WeakReferenceTest {

    /**
     * 弱引用
     * 下一次GC则回收
     * @param args
     */
    public static void main(String[] args) {
        WeakReferenceTest weakReferenceTest = new WeakReferenceTest();
        WeakReference weakReference = new WeakReference(weakReferenceTest);

        weakReferenceTest = null;

        System.out.println(weakReference.get());

        Runtime.getRuntime().gc();

        System.out.println(weakReference.get());
    }
}
