package com.zeroten.java001.Extend;

public interface Interface {

    class InnerClass{

    }

    interface InnerInterface{

    }

    int MAX_COUNT=99;//接口中不能包含实例域和静态方法abstract ,final.....但是java8开始,在方法声明前添加default关键字作为默认实现(默认方法/拓展方法)
                      //但是默认方法不能覆盖Object中的方法,却可以重载Object中的方法.
                      //接口中可以声明静态方法,静态方法必须有方法体

    void method();//接口中的方法不能有方法体


    static void print0(){
        System.out.println("Java8有的接口中的默认方法");
    }

}
