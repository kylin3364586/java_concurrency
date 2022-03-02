package com.jike.jikehsijian;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class test2 {


    private List<String> wrongMethod(FooService fooService, Integer i, String s, String t) {
        Optional.ofNullable(fooService)
                .map(FooService::getBarService)
                .filter(barService -> "OK".equals(barService.bar()))
                .ifPresent(result -> System.out.println("OK"));

//        if (fooService.getBarService().bar().equals("OK"))
//            System.out.println("OK");
        return null;
    }

    public int wrong(String test) {
//        return wrongMethod(test.charAt(0) == '1' ? null : new FooService(),
//                test.charAt(1) == '1' ? null : 1,
//                test.charAt(2) == '1' ? null : "OK",
//                test.charAt(3) == '1' ? null : "OK")
//                .size();
        return Optional.ofNullable(
                wrongMethod(
                        test.charAt(0) == '1' ? null : new FooService(),
                        test.charAt(1) == '1' ? null : 1,
                        test.charAt(2) == '1' ? null : "OK",
                        test.charAt(3) == '1' ? null : "OK")
                )
                .orElse(Collections.emptyList())
                .size();
    }

    class FooService {
        private BarService barService;

        public BarService getBarService() {
            return barService;
        }
    }

    class BarService {
        String bar() {
            return "OK";
        }
    }

    public static void main(String[] args) {
        new test2().wrong("1111");
    }
}
