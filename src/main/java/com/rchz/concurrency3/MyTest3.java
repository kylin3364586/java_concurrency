package com.rchz.concurrency3;

/*

    JVM中的同步（synchronized）是基于进入与退出监视器对象（管程对象）（monitor）来实现的，每个对象都会有一个monitor对象，monitor对象会和Java对象一起创建与销毁，
    monitor对象是由C++来实现的。

    当多个线程访问同一段同步代码时，这些线程会被放到一个EntryList集合中，处于阻塞状态的线程都会放到这个集合中，接下来，当线程获取到对象的monitor时，可执行自己的业务，
    monitor是依赖于底层操作系统的mutex lock来实现互斥的，线程获取mutex成功，则会持有该mutex，这是其他线程就无法获取mutex。

    如果线程调用了wait方法，那么该线程就会释放掉所持有的mutex，并且该线程就会进入到WaitSet集合（等待集合）中，等待下一次被其他线程调用notify/notifyAll唤醒，
    如果当前线程顺利执行完毕，也会释放掉持有的mutex。

    总结一下：同步锁在这种实现方式当中，因为monitor是依赖于底层操作系统实现的，这样就存在用户态和内核态之间的切换 ，所以会增加性能开销。


    通过对象互斥锁的概念来保证共享数据操作的完整性，每个对象都对应于一个可称之为【互斥锁】的标记，这个标记用于保证在任何时刻，只能有一个线程访问该对象。

    那些处于EntrySet与WaitSet中的线程均处于阻塞状态，阻塞操作是有系统来完成的，在Linux下是通过pthread_mutex_lock函数来实现的。
    线程被阻塞后便会进入内核调度状态，这会导致系统在用户态和内核态之间来回切换，严重影响锁性能。

    解决上述问题的办法是自旋（Spin）。其原理是：当对象发生monitor争用时，若Owner能在很短时间内释放锁，那些正在争用的线程可以稍微等一下（自旋），
    在Owner线程释放锁后，争用线程可立即获取到锁，从而避免系统阻塞。不过，当Owner运行时间超过了临界值后，争用线程自旋一段时间后依然无法获取到锁，
    这时争用线程会停止自旋而进入到阻塞状态。所以总体思想是:先自旋，不成功在阻塞，尽量降低阻塞的可能性，这对那些执行时间很短的代码块来说有极大的性能
    提升。显然，自旋在多核处理器上才有意义。

    互斥锁属性：
    1.PTHREAD_MUTEX_TIMED_NP:缺省值，也就是普通锁,当一个线程加锁以后，其余请求锁的线程会形成一个等待队列，并且在解锁后按照优先级获取到锁。
      这种策略可以保证资源分配的公平性。
    2.PTHREAD_MUTEX_RECURSIVE_NP:嵌套锁，允许一个线程对同一个锁成功获取多次，并通过unlock解锁。如果是不同线程请求，则在加锁线程解锁时重新进
      行竞争。
    3.PTHREAD_MUTEX_ERRORCHECK_NP:检错锁，如果一个线程请求同一个锁，则返回EDEADLK，否则与PTHREAD_MUTEX_TIMED_NP类型动作相同，这样就保
      证了当不允许多次加锁时不会出现最简单的死锁情况。
    4.PTHREAD_MUTEX_ADAPTIVE_NP:适应锁，动作最简单的锁类型，仅仅等待解锁后重新竞争。


    ===============================

    在JDK1.5之前，我们若想实现同步，只能通过synchronized关键字来实现；底层，Java也是通过synchronized关键字来做到数据原子性维护的，synchronized
    关键字是JVM实现的一种内置锁，从底层角度来说，这种锁的获取与释放都是JVM来帮我们隐式实现的。

    从JDK1.5开始，并发包引入了Lock锁，Lock同步锁是基于Java来实现的，因此获取锁和释放锁都是通过Java代码来实现与控制的；然而，synchronized是基于
    底层操作系统的Mutex Lock实现的，每次对锁的释放与获取都会带来用户态和内核态之间的切换，这种切换会极大的增加系统的负担；在并发量较高时、也就是锁竞争
    非常激烈的情况下，synchronized在性能上的表现就非常差。

    从JDK1.6开始，synchronized锁的实现发生了很大变化；JVM引入了相应的手段来优化synchronized锁的性能，这种提升涉及到、偏向锁、轻量级锁、重量级锁等
    ，从而减少锁竞争带来的用户态与内核态之间的切换；这种锁优化实际上是通过Java对象头中的一些标志位来实现的；对于锁的访问与改变，实际上都与Java对象头息息相关。

    从JDK1.6开始，对象实例在堆中会被划分为三个组成部分：对象头、实例数据、对其填充。

    对象头主要也是由3块内容来构成：
    1.Mark Word
    2.指向类的指针
    3.数组长度

    其中Mark Word （他记录了对象、锁、垃圾回收相关的信息，在64位的JVM中，其长度也是64bit）的位置信息包括如下组成部分：
    1.无锁标记
    2.偏向锁标记
    3.轻量级锁标记
    4.重量级锁标记
    5.GC标记

   对于synchronized锁来说，锁升级主要通过Mark Work中的锁标志位与是否是偏向锁标志位来达成的；synchronized关键字所对应的锁都是先从偏向锁开始，
   随着锁竞争的不断升级，逐步演化至轻量级锁、重量级锁。

   无锁->偏向锁->轻量级锁->重量级锁







 */
public class MyTest3 {

    public static synchronized void method(){
        int i = 0;
        int[] arr;
        String str = "0";
        System.out.println("hello world");
    }
}
