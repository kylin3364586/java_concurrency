package com.rchz.concurrency3;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-06-06- 15:05:00
 */
public class BigDecimalTest {

    @Test
    public void test1(){
        BigDecimal a = BigDecimal.valueOf(35634535255456719.22345634534124578902);
        System.out.println(a.toString());
        System.out.println(a.toPlainString());
    }

}
