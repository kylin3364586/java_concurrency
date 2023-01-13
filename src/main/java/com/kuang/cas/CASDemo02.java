package com.kuang.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 原子引用（带版本号的原子操作），可解决ABA问题
 *
 *
 * ABA问题：
 * 假如有一个属性a=1,
 * 有两个线程,A线程将1->2
 * B线程将1->3,接着又将3->1这个过程A线程是没有感知的，这就是ABA问题
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-13- 10:35:00
 */
public class CASDemo02 {

    public static void main(String[] args) {
        //期望值，版本号
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);

        //原理与乐观锁相同
        new Thread(()->{
            System.out.println("a1 " + atomicStampedReference.getStamp());//查询版本号

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //期望值，修改值，版本号，版本号+1
            atomicStampedReference.compareAndSet(1, 2,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("a2 " + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(2, 1,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("a3 " + atomicStampedReference.getStamp());
        },"a").start();


        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();//查询版本号
            System.out.println("b1 " + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //将1改为6,由于上面版本号已经变为3,不是最初定义的1，此处会修改失败
            System.out.println(atomicStampedReference.compareAndSet(1, 6,
                    stamp, stamp + 1));
            System.out.println("b2 " + atomicStampedReference.getStamp());
        },"b").start();

    }

}
