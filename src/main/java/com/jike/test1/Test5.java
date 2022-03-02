package com.jike.test1;

import java.util.ArrayList;
import java.util.List;

public class Test5 {


    public static void main(String[] args) {
        //上限通配符
        List<? extends Obj> l = new ArrayList<Man>();
        l = new ArrayList<Boy>();

        //下限通配符
        List<? super Obj> list = new ArrayList<Obj>();
        list.add(new People());
        list.add(new Boy());
        list.add(new Obj());


        Object[] arr1 = {1,2,3,4,5};
        Object[] arr2 = {1,2,3,4,5};

        System.arraycopy(arr1, 4, arr2, 3, 1);
//        integers.remove(3);
        System.out.println(arr2);
        int length = arr2.length;
        arr2[--length] = null;
        System.out.println(arr2);
    }
}
class Obj{

}
class People extends Obj{

}

class Man extends People{

}
class Woman extends People{

}
class Boy extends People{

}