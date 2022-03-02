package com.jike.jvm.string;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2021年12月17日 16:39:00
 */
public class CanReliveObj {

    private static CanReliveObj obj = new CanReliveObj();

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        obj = this;
        System.out.println("执行finalize方法，复活obj");
    }

    public static void main(String[] args) throws InterruptedException {

        obj = null;
        System.gc();//System.gc方法执行之前，会仅调用一次finalize方法
        System.out.println("第一次回收对象");
        print(obj);
        Thread.sleep(2000);

        obj = null;
        System.gc();
        System.out.println("第二次回收对象");
        print(obj);


    }

    public static void print(CanReliveObj obj){
        if(null == obj){
            System.out.println("死亡");
        }else{
            System.out.println("复活");
        }
    }
}
