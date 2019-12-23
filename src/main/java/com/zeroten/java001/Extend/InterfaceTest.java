package com.zeroten.java001.Extend;

import org.testng.annotations.Test;

public class InterfaceTest {

    @Test
    public void Test1 (){

        //Interface i1=new Interface();接口不能实例化
        InterfaceImpl i2=new InterfaceImpl();
        i2.method();
        i2.method2();
        System.out.println(i2 instanceof Interface);
        System.out.println(i2 instanceof Interface2);

        System.out.println(InterfaceImpl.MAX_COUNT);//推荐
        System.out.println(Interface.MAX_COUNT);
        System.out.println(i2.MAX_COUNT);

        Interface.print0();//接口中的静态方法只能通过接口来访问

    }

}
