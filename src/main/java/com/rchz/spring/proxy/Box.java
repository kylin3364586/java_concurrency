package com.rchz.spring.proxy;

//泛型
public class Box<T> {

    private T obj;
    public void setBox(T obj){
        this.obj = obj;
    }
    public T getBox(){
        return obj;
    }
}

class Apply{
        public void invoker(){
            System.out.println("执行");
        }
}
class Test{
    public static void main(String[] args) {
        //不带泛型参数,需要强制转换
        Box box = new Box();
        box.setBox(new Apply());
        Apply apply = (Apply) box.getBox();

        //带泛型参数,不用强制转换
        Box<Apply> applyBox = new Box<>();
        applyBox.setBox(new Apply());
        Apply apply1 = applyBox.getBox();
    }
}