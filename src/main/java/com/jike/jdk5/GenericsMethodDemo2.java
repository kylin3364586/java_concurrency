package com.jike.jdk5;

/**
 * 泛型方法(指定泛型上下边界)
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月19日 16:46:00
 */
public class GenericsMethodDemo2 {

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

    //public <T extends Number> T test(Generics<T extends Number> generics){，编译器会报错："Unexpected bound"
    public <T extends Number> T test(Generics<T> generics){
        System.out.println(generics.toString());
        return generics.getKey();
    }

    public static void main(String[] args) {
        Generics generics = new GenericsMethodDemo2().new Generics<Long>(123L);
        new GenericsMethodDemo2().test(generics);
    }
}
