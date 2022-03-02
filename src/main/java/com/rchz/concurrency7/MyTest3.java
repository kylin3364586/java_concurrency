package com.rchz.concurrency7;

/*
    ThreadLock
    本质上，Thread Lock是用空间换取时间，从而实现每个线程当中都会有一个变量的副本，这样每个线程就都会操作这个副本，从而完全规避了多线程并发的问题。
    Java中存在四种类型的引用：
    1.强引用（strong）
    2.软引用（soft）
    3.弱引用（weak）
    4.虚引用（phantom）

    public class Test{
        public static final ThreadLocal<String> s1 = new ThreadLocal<>();
    }

    try{
        ...
        ...
        ...
    } finally{
        s1.remove();
    }


 */
public class MyTest3 {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set("hello word");

        System.out.println(threadLocal.get());

        threadLocal.remove();
    }
}
