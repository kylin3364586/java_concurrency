package com.jike.test1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test6 {

    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("1");
        };

        //输出
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("12");

        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("h");


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("11");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        new Thread(() -> {
            System.out.println(22);
        }).start();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(System.out::println);
        list.forEach((i) -> {
            System.out.println(i);
        });

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        list1.stream().map((integer -> integer * 3)).forEach(System.out::println);
        List<Integer> collect = list1.stream().map(i -> i * 2).collect(Collectors.toList());
        collect.forEach(System.out::println);

        //reduce函数，用来将值进行合并
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        Integer integer = list2.stream().map(i -> i + 1).reduce((s1, s2) -> s1 + s2).get();
        integer = list2.stream().map(Integer::intValue).reduce((s1, s2) -> s1 + s2).get();
        System.out.println(integer);

        //reduce函数，用来将值进行合并，map和reduce函数式函数式变成的核心。
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
        //求最小值
        double reduce = Stream.of(2.0, -5.0, -1.6, 8.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(reduce);
        //求最大值
        double reduce1 = Stream.of(2.0, -5.0, -1.6, 8.0).reduce(Double.MIN_VALUE, Double::max);
        System.out.println(reduce1);
        //求和，有起始值2
        Integer reduce2 = Stream.of(3, 5, 6).reduce(2, Integer::sum);
        System.out.println(reduce2);
        //求和，无初始值
        Integer reduce3 = Stream.of(3, 5, 6).reduce(Integer::sum).get();
        System.out.println(reduce3);
        // 过滤，字符串连接，concat = "ace"
        String str = Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
        System.out.println(str);

        System.out.println("Z".compareTo("Z"));

        //过滤长度小于2的字符
        List<String> strList = Arrays.asList("abc", "eqwr", "bcd", "qb", "ehdc", "jk");
        List<String> collect1 = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        collect1.forEach(System.out::println);


        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("------------");
        //J开头的数据
        filter(languages, (s) -> ((String) s).startsWith("J"));
        System.out.println("------------");
        //a结尾的数据
        filter(languages, (s) -> ((String) s).endsWith("a"));
        System.out.println("------------");

        filter(languages, (s) -> true);
        System.out.println("------------");

        filter(languages, (s) -> false);
        System.out.println("------------");
        //长度大于4
        filter(languages, (s) -> ((String) s).length() > 4);
        System.out.println("------------");
        //以J开头且长度等于4
        Predicate<String> startWithJ = s -> s.startsWith("J");
        Predicate<String> length = s -> s.length() == 4;
        languages.stream().filter(startWithJ.and(length)).forEach(System.out::println);
        System.out.println("------------");
        //对列表的每个元素使用函数
        List<String> strings = Arrays.asList("abc", "eqwr", "bcd", "qb" , "ehdc", "jk");
        String collect2 = strings.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(collect2);
        //使用distinct进行去重
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> collect3 = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        collect3.forEach(System.out::println);
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());


        List<Integer> sort= Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> collect4 = sort.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(collect4);

    }

    public static void filter(List<String> names, Predicate predicate) {
        names.stream().filter(x -> predicate.test(x)).forEach(System.out::println);
    }
}
