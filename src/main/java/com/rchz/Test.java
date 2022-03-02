package com.rchz;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("1","2");
        String put = map.put("1", "3");
        System.out.println(put);

        map.get("");

        System.out.println(2 >>> 20);

        long c = 2;
        for (int i = 1; i < 20; i++) {
             c = c * 2;
        }
        System.out.println(c);
        Integer.highestOneBit(1);
        System.out.println( 5 ^ 2);


        System.out.println("------Complementation------");
        System.out.println(7 % 4);
        System.out.println((-7) % 4);
        System.out.println(7 % (-4));
        System.out.println((-7) % (-4));

        System.out.println();
        System.out.println("------Modulo Operation------");
        System.out.println(Math.floorMod(7, 4));
        System.out.println(Math.floorMod(-7, 4));
        System.out.println(Math.floorMod(7, -4));
        System.out.println(Math.floorMod(-7, -4));

        System.out.println(6 ^ 6);


        Object o = "";
        o.hashCode();

        Integer i = 0;
        i.hashCode();

        String s = "";
        s.hashCode();
    }
}
