package com.jike.jvm;

public class MyTest3 {

    static class Father{
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Son extends Father{
        private static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Son.B);
    }
}