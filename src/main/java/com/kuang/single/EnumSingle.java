package com.kuang.single;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

/**.枚举单例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-12- 17:33:00
 */
public enum EnumSingle {

    INSTRACE;

    public EnumSingle EnumSingle() {
        return INSTRACE;
    }


}

class Test{

    @SneakyThrows
    public static void main(String[] args) {
//        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        //枚举只有一个有参构造,需要通过jad工具反编译： private EnumSingle(String s, int i)
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle = declaredConstructor.newInstance();//抛错，枚举不能通过反射创建：java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        System.out.println(enumSingle);
    }
}
