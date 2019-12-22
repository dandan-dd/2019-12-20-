package com.zeroten.java001.Extend;

import org.testng.annotations.Test;

import java.util.Date;

public class EmployeeTest {

    @Test
    public void testPrint(){

        //调用的是有参数构造方法
        Employee yg1=new Employee("员工1",new Date(),100);
        //调用无参数构造方法
//        yg1.setName("员工1");//公有方法
//        //yg1.name("员工1");已设为私有，无法访问
//        yg1.setHireDay(new Date());
//        yg1.setSalary(100);
        yg1.printInfo();

        System.out.println("=================================================");

        //new调用的是有参数构造方法
        Manager mg1=new Manager("经理1",new Date(),120,30);
        //new调用的是无参数构造方法
//        Manager mg1=new Manager();
//        mg1.setName("经理1");
//        mg1.setHireDay(new Date());
//        mg1.setSalary(120);
//        mg1.setBonus(30);
        mg1.printInfo();
    }

    @Test //多态
    public void testDuoTai(){
        Employee yg1=new Employee("员工1",new Date(),100);
        Manager mg1=new Manager("经理1",new Date(),120,30);
        MasterManager zmg1=new MasterManager("zo经理1",new Date(),120,30);

        Employee yg=yg1;//???
        yg.printInfo();//???

        yg=mg1;
        yg.printInfo();

        yg=zmg1;
        yg.printInfo();
    }
}
