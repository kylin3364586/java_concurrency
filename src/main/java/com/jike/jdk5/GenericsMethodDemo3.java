package com.jike.jdk5;

/**
 * 泛型方法(指定泛型上下边界)
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月19日 16:46:00
 */
public class GenericsMethodDemo3 {

    public class Generics<T extends Number> {
        private T key;

        public Generics(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }
    }

    public void test(Generics<? super Long> generics){
        System.out.println(generics.toString());
    }

    public static void main(String[] args) {
        Generics generics = new GenericsMethodDemo3().new Generics<Integer>(123);
        new GenericsMethodDemo3().test(generics);
    }
}
