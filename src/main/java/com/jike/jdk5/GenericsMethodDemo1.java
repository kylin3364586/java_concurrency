package com.jike.jdk5;

/**
 * 泛型方法
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月19日 16:46:00
 */
public class GenericsMethodDemo1 {

    public class Generics<T> {
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


    public <T> T test(Generics<T> generics){
        System.out.println(generics.toString());
        return generics.getKey();
    }

    public static void main(String[] args) {
        Generics generics = new GenericsMethodDemo1().new Generics<String>("123");
        new GenericsMethodDemo1().test(generics);
    }
}
