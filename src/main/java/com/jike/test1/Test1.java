package com.jike.test1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/test1")
@RestController
public class Test1 {


    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->null);


    @GetMapping("wrong")
    public Map wrong(@RequestParam("userId") Integer userId){

        String before = Thread.currentThread().getName() + ":" + threadLocal.get();

        threadLocal.set(userId);

        try {
            String after = Thread.currentThread().getName() + ":" + threadLocal.get();

            Map map = new HashMap();
            map.put("before",before);
            map.put("after",after);
            return map;
        }finally {
            threadLocal.remove();
        }

    }

}
