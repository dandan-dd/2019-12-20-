package com.zeroten.java001.Extend;

import org.testng.annotations.Test;

public class AbstractTest {

    @Test
    public void testPrint(){
        Person p1=new Teacher();
        System.out.println(p1.getDescrition());

        Person s1=new Student();
        System.out.println(s1.getDescrition());

       // Person person=new Person();抽象类不能被实例化,不能使用new操作符
    }

}
