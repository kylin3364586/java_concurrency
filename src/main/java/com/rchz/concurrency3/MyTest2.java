package com.rchz.concurrency3;

/*
    使用synchronized修饰方法时，并没有出现monitorenter和monitorexit指令，而是使用了ACC_SYNCHRONIZED标志。
    JVM使用了ACC_SYNCHRONIZE访问标志来区分一个方法是否为同步方法，当方法被调用时，会先去验证方法是否有ACC_SYNCHRONIZED标志，
    如果有，则会先去持有当前方法对象的monitor，接着执行方法体，执行过程中其他线程无法无法获取到这个monitor，执行完毕释放monitor
 */
public class MyTest2 {

    public synchronized void method(){
        System.out.println("hello world");
    }
}
