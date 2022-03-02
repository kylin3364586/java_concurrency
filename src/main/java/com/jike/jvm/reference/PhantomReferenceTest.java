package com.jike.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月23日 17:34:00
 */
public class PhantomReferenceTest {

    /**
     * 虚引用
     * 不影响对象声明周期，
     * @param args
     */
    public static void main(String[] args) {

        Object object = new Object();
        ReferenceQueue rq = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(object, rq);

        System.out.println(phantomReference);
    }
}
