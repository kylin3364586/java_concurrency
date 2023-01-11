package com.kuang.forkjoin;

import lombok.SneakyThrows;

import java.util.concurrent.RecursiveTask;

/**
 * 使用场景：大数据量，并行执行
 *
 *
 * 任务拆分执行，汇总结果
 * 工作窃取：内部维护一个双端队列
 * @author kylin
 * @version 1.0.0
 * @Description 求和计算任务
 * @createTime 2023-01-11- 14:47:00
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //临界值
    private Long temp=10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 计算
     * 小于临界值普通计算，超过则使用forkJoin
     * @return
     */
    @SneakyThrows
    @Override
    protected Long compute() {
        if((end - start) < temp){
            //普通计算
            long num = 0L;
            for (long i = start; i <= end; i++) {
                num+=i;
            }
            return num;
        }else{//ForkJoin 拆分执行
            long middle = (start + end) / 2;//中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start,middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1,end);
            task2.fork();//拆分任务，把任务压入线程队列
            return task1.join() + task2.join();
        }
    }
}
