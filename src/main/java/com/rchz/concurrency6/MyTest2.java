package com.rchz.concurrency6;

import java.util.concurrent.atomic.AtomicInteger;

/*
    对于CAS来说，其操作数要涉及到如下三个：

    1.需要被操作的内存值V
    2.需要进行比较的值A
    3.需要进行写入的值B

    只有当V==A的时候,CAS才会通过原子操作来更新V的值为B

    关于CAS的限制或问题：
    1.循环开销问题：并发量大的情况下会导致一直自旋
    2.只能保证一个变量的原子操作：可以通过AtomicReference来实现对多个变量的原子操作
    3.ABA问题：就是说一个线程把数据A变为了B，然后又重新变成了A。此时另外一个线程读取的时候，发现A没有变化，就误以为是原来的那个A。这就是有名的ABA问题。

 */

public class MyTest2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.getAndSet(8));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
