package com.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义starter
 *
 * 打包：mvn clean install -Dmaven.test.skip=true
 */
@SpringBootApplication
public class MyTestStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTestStarterApplication.class, args);
    }

}
