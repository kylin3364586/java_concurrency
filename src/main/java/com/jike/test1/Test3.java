package com.jike.test1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Test3 {

    private static int LOOP_COUNT = 100000;
    private static int THREAD_COUNT = 10;
    private static int ITEM_COUNT = 10;

    public static Map<String, Long> normalues() throws InterruptedException {
        ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(()->{
            IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(i->{
                String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
                synchronized (concurrentHashMap){
                    if(concurrentHashMap.contains(key)){
                        concurrentHashMap.put(key, concurrentHashMap.get(key) + 1);
                    }else{
                        concurrentHashMap.put(key,1L);
                    }
                }
            });
        });
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return concurrentHashMap;
    }

    public static void main(String[] args) throws InterruptedException {

        normalues();
    }
}
