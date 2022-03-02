package com.rchz.strategy;

import java.util.HashMap;
import java.util.Map;

public class Strategy {

    static Map<String, TestStrategy> map;
    static {
        map = new HashMap<>();
        map.put("xiaoming",new xiaoming());
        map.put("xiaozhang",new xiaozhang());
        map.put("xiaowang",new xiaowang());
    }

    public static TestStrategy getTestStrategy(String name){
        return map.get(name);
    }

    public static void main(String[] args) {
        Strategy.getTestStrategy("xiaoming").print();
    }
}
