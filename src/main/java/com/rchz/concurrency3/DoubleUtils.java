package com.rchz.concurrency3;

import java.math.BigDecimal;

public final class DoubleUtils {

    public static double round(int scale, double value) {
        return new BigDecimal(String.valueOf(value)).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double add(int scale, double ... args) {
        BigDecimal sum = new BigDecimal("0");
        for (double arg : args) {
            sum = sum.add(new BigDecimal(String.valueOf(arg)));
        }
        return sum.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double sub(int scale, double v1, double v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double mul(int scale, double ... args) {
        BigDecimal sum = new BigDecimal("1");
        for (double arg : args) {
            sum = sum.multiply(new BigDecimal(String.valueOf(arg)));
        }
        return sum.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double div(int scale, double v1, double v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double mul(double ... args) {
        BigDecimal sum = new BigDecimal("1");
        for (double arg : args) {
            sum = sum.multiply(new BigDecimal(String.valueOf(arg)));
        }
        return sum.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println("=== 四舍五入(保存两位小数) ===");
        System.out.println(String.format("0.245 ≈ %s", round(2, 0.245)));
        System.out.println(String.format("0.244 ≈ %s", round(2, 0.244)));
        System.out.println("=========== 加法  ==========");
        System.out.println(String.format("0.2 + 0.4 = %s", 0.2 + 0.4));
        System.out.println(String.format("0.2 + 0.4 = %s", add(5, 0.2, 0.4)));
        System.out.println("=========== 减法  ==========");
        System.out.println(String.format("1.0 - 0.9 = %s", 1.0 - 0.9));
        System.out.println(String.format("1.0 - 0.9 = %s", sub(5, 1.0, 0.9)));
        System.out.println("========== 乘法  ===========");
        System.out.println(String.format("4.015 * 100 = %s", 4.015 * 100));
        System.out.println(String.format("4.015 * 100 = %s", mul(5, 4.015, 100)));
        System.out.println("=========== 除法  ==========");
        System.out.println(String.format("123.3 / 100 = %s", 123.3 / 100));
        System.out.println(String.format("123.3 / 100 = %s", div(5, 123.3, 100)));
    }
}
