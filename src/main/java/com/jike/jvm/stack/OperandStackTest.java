package com.jike.jvm.stack;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年11月30日 15:18:00
 */
public class OperandStackTest {

    public static void main(String[] args) {
        byte i = 15;
        int j = 8;
        int k = i + j;
    }


    public void add(){
        int i1 = 10;
        i1++;
        int i2 = 10;
        ++i2;

        int i3 = 10;
        int i4 = i3++;
        int i5 = 10;
        int i6 = ++i5;

        int i7 = 10;
        i7 = ++i7;
        int i8 = 10;
        i8 = i8++;

        int i9 =10;
        int i10 = i9++ + ++i9;

    }
}
