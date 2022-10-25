package com.rchz.java8;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Stream {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = list.stream().filter(i -> i == 3).collect(Collectors.toList());
        System.out.println(list.toString());
        System.out.println(collect.toString());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(22);
            }
        }).start();
        new Thread(() -> System.out.println("11")).start();
    }

    //filter拿到符合条件的
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = list.stream().filter(integer -> integer > 2).collect(Collectors.toList());
        System.out.println(collect.toString());
    }

    @Test
    public void test2(){
        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        list.add(map);

    }

    @Test
    public void test3(){
        List<User> list = new ArrayList<>();
        list.add(User.builder().id(1L).name("张三").sex(20).build());
        list.add(User.builder().id(2L).name("李四").sex(21).build());
        list.add(User.builder().id(3L).name("王五").sex(22).build());
        list.add(User.builder().id(4L).name("王六").sex(23).build());
        //拿到id=3的数据
        User user1 = list.stream().filter(user -> user.getId() == 3L).findFirst().get();
        System.out.println(user1);

        //id总和
        Long aLong = list.stream().map(User::getId).reduce((i, s) -> i + s).get();
        System.out.println(aLong);

        //id分别加1
        List<Object> collect1 = list.stream().map(user -> {
            user.setId(user.getId() + 1);
            return user;
        }).collect(Collectors.toList());
        System.out.println(collect1.toString());

        Long collect = list.stream().flatMapToLong(value -> LongStream.of(value.getId() + 1)).sum();
        System.out.println(collect);

    }


    @Test
    public void stream(){
        Arrays.asList("a1","a2","a3").stream().forEach(System.out::println);
        Arrays.stream(new int[]{1,2,3}).forEach(System.out::println);
    }

    @Test
    public void of(){
        String[] str = {"a","b","c"};
        java.util.stream.Stream.of(str).forEach(System.out::println);
        java.util.stream.Stream.of("a","b","c").forEach(System.out::println);
        java.util.stream.Stream.of(1,2,"a").map(item -> item.getClass().getName()).forEach(System.out::println);

    }


    @Test
    public void iterate(){
        java.util.stream.Stream.iterate(2, integer -> integer * 2).limit(10).forEach(System.out::println);
        java.util.stream.Stream.iterate(BigInteger.ZERO, item -> item.add(BigInteger.TEN)).limit(5).forEach(System.out::println);
    }

    @Test
    public void generate(){
        java.util.stream.Stream.generate(() -> "test").limit(3).forEach(System.out::println);
        java.util.stream.Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void test4(){
        IntStream.range(1,3).forEach(System.out::println);
        IntStream.range(0,3).mapToObj(s-> "x").forEach(System.out::println);

        IntStream.rangeClosed(1,3).forEach(System.out::println);
        DoubleStream.of(1.1,2.2,3.3).forEach(System.out::println);
    }

   @Test
    public void test5(){
       List<User> list = new ArrayList<>();
       list.add(User.builder().id(1L).name("张三").sex(20).build());
       list.add(User.builder().id(2L).name("李四").sex(21).build());
       list.add(User.builder().id(3L).name("王五").sex(22).build());
       list.add(User.builder().id(4L).name("王六").sex(23).build());
       list.add(User.builder().id(5L).name("王七").sex(24).build());

       List<User> collect = list.stream().filter(u -> u.getSex() > 20)//大于20
               .sorted(Comparator.comparing(User::getSex).reversed())//倒叙
               .distinct()//去重
               .limit(5)//取5个
               .collect(Collectors.toList());
       System.out.println(collect);

   }
    @Test
    public void test7(){
        long l = 1;
        int i = 1;
        switch (i){
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
        }

//        double a = Math.round(11.9);
//        System.out.println(a);
        long round = Math.round(-11.5);
        System.out.println(round);

        System.out.println(2<<3);

        final int aa = 10;

    }

    @Test
    public void test8(){
        List<Integer> firstPeek = new ArrayList<>();
        List<Integer> secondPeek = new ArrayList<>();
        List<Integer> result = IntStream.rangeClosed(1, 10)
                .boxed()
                .peek(i -> firstPeek.add(i))
                .filter(i -> i >5)
                .peek(i -> secondPeek.add(i))
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("firstPeek:" + firstPeek);
        System.out.println("secondPeek:" + secondPeek);
        System.out.println("result:" + result);

    }

    @Test
    public void test9(){
        java.util.stream.Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }



}
