package com.rchz.concurrency6;

/*
    CAS

    1.synchronized关键字与lock等锁机制都是悲观锁：无论做任何操作，都需要先上锁在执行，从而保证所有操作都是由当前这个线程来完成的。
    2.乐观锁：线程再操作之前不会做任何预先处理，而是直接去执行；当在最后执行变量更新的时候，当前线程需要有一种机制来确保
            当前被操作的变量没有被其他线程修改；CAS是乐观锁极为重要的一种实现。

    CAS (Compare And Swap)
    比较与交换：这是一个不断循环的过程，一直到变量值被修改成功为止，CAS本身是由硬件指令来提供支持的，换句话说，硬件通过一个原子指令
    来实现比较与交换；因此，CAS可以保证变量操作的原子性。
 */

public class MyTest1 {
    private int count;

    public synchronized int getCount() {
        return count;
    }

    /*
        读取 ->修改 ->写入：这三个操作并非原子操作
     */
    public synchronized void increaseCount(){
        ++this.count;
    }
}
