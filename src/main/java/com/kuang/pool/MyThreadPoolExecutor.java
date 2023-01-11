package com.kuang.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * @author kylin
 * @version 1.0.0
 * @Description 开发中建议使用以下方式，而不是用Executors
 * @createTime 2023-01-10- 16:11:00
 */
public class MyThreadPoolExecutor {

    public static void main(String[] args) {
        /**
         * 自定义线程池
         *
         *  四种拒绝策略：
         *  new ThreadPoolExecutor.AbortPolicy() 超过最大线程数+缓存队列长度时，抛错! java.util.concurrent.RejectedExecutionException:
         *  new ThreadPoolExecutor.CallerRunsPolicy() 超过最大线程数+缓存队列长度时，由调用当前方法的线程代替执行！此处是main线程执行
         *  new ThreadPoolExecutor.DiscardPolicy()  超过最大线程数+缓存队列长度时，丢弃任务！
         *  new ThreadPoolExecutor.DiscardOldestPolicy() 超过最大线程数+缓存队列长度时，被拒绝任务的处理程序丢弃最早的未处理请求，然后重试execute
         *
         *  最大线程数定义：
         *  1.CPU密集型  服务器是几核，就是几，保证CPU的效率最高
         *  2.IO密集型  判断程序比较耗IO的线程数，大于他就可以了
         */
        //获取CPU核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, //核心线程数
                Runtime.getRuntime().availableProcessors(), //最大线程数
                3, //超时时间,当线程数大于核心数时，这时多余的空闲线程在终止前等待新任务的最长时间。
                TimeUnit.SECONDS,//等待时间单位
                new LinkedBlockingQueue(3),//缓存队列
                Executors.defaultThreadFactory(),//创建线程工厂
                new ThreadPoolExecutor.DiscardOldestPolicy()//拒绝策略
        );

        for (int i = 0; i < 9; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+" ok");
            });
        }

        threadPoolExecutor.shutdown();
    }
}
