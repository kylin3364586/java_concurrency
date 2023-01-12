package com.rchz.concurrency4;

/*
    volatile关键字

    volatile关键字主要有以下三方面作用：
    1.不保证变量的原子性
    2.防止指令重排序
    3.实现变量可见性

    当使用volatile关键字修饰变量时，应用就不会从寄存器取值，而是从内存（高速缓存）中取。

    volatile与锁类似的地方有以下两点：
    1.确保变量的内存可见性
    2.防止指令重排

    volatile可以确保对变量写的原子性，不具备排他性。
    另外重要的一点是：锁可能会导致线程的上下文切换（内核态与用户态之间的切换），但是volatile不会出现这种情况。

    volatile a = b + 2;
    volatile c = c++;

    volatile int count = 1;
    volatile boolean flag = false;
    如果要实现volatile写操作的原子性，那么在等号右侧的赋值中就不能出现被多线程共享的变量，哪怕这个变量也是volatile修饰也不行。

    volatile Date date = new Date();

    防止指令重排序与实现变量的可见性都是通过一种手段来实现的：内存屏障（memory barrier）

    int a = 1;
    String s = "hello";

    内存屏障（Release Barrier,释放屏障）

    volatile boolean flag = false;//写入操作

    内存屏障（Store Barrier,存储屏障）

    Release Barrier：防止下面的volatile与上面的所有指令操作重排序。
    Store Barrier：刷新处理器缓存，可以确保该存储屏障之前的所有操作结果对其他处理器都可见。


    内存屏障（Load Barrier,加载屏障）

    boolean v1 = flag;

    内存屏障（Acquire Barrier,获取屏障）

    int a = 1;
    String s = "hello";

    Load Barrier:可以刷新处理器缓存，同步其他处理器对该volatile变量修改的结果。
    Acquire Barrier:可以防止上面的volatile读取操作与下面的所有指令重排序。


    对于volatile关键字对变量的所有操作，本质上都是通过内存屏障来执行的。

    内存屏障兼具了两方面的能力：1.防止指令重排序，2实现内存变量的可见性

    1.对于读操作来说，volatile可以确保该操作与其后面的所有操作不会进行指令重排序。
    2.对于写操作来说，volatile可以确保该操作与其前面的所有操作不会进行指令重排序。


    volatile与锁的一些比较

    锁同样具备内存变量可见性和指令重排序

    monitorenter
    内存屏障（Acquire Barrier,获取屏障）

    ......

    内存屏障（Release Barrier,释放屏障）
    monitorexit
 */
public class MyTest3 {

}
