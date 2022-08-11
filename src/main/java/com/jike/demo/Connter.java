package com.jike.demo;

import lombok.Data;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月09日 16:43:00
 */
@Data
public class Connter {
    public int count = 0;

    @Override
    public String toString() {
        return "Connter{" +
                "count=" + count +
                '}';
    }
}
