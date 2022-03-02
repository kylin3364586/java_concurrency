package com.jike.jikehsijian;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test1 {


    private static List<List<Integer>> lists = new ArrayList<>();


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            List<Integer> list = IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList());
            List<Integer> subList = list.subList(0, 1);
            lists.add(subList);
        }
    }
}
