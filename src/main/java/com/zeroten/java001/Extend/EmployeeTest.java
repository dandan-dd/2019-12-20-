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
        System.out.println("我的奖金是"+mg1.getBonus());
        MasterManager zmg1=new MasterManager("zo经理1",new Date(),120,30);
        System.out.println("我的奖金是"+zmg1.getBonus());


        Employee yg=yg1;//???
        yg.printInfo();//???

        yg=mg1;//经理类型自动转换为员工
        yg.printInfo();
        //经理的值赋值给员工之后,就无法在调用员工的方法
        //System.out.println("我的奖金是"+yg.getBonus());

        Manager m1=(Manager) yg;//再把员工强制转换为经理
        System.out.println("我的奖金是"+m1.getBonus());

        yg=zmg1;
        yg.printInfo();
        System.out.println(yg instanceof MasterManager);
        System.out.println(yg instanceof Manager);
        System.out.println(yg instanceof Employee);

        Object object=new Date();
        if(object instanceof Manager){
            Manager m2=(Manager) object;//类型不一样,无法转换,且仅限于父子类转换
        }else{
            System.out.println("object不是Manager");
        }
    }

    @Test
    public void testObjectMethod(){
        Employee employee =new Employee();
        System.out.println(employee.getClass().getName());//整个路径
        System.out.println(employee.getClass().getSimpleName());//类名
        System.out.println(employee.hashCode());//哈希值,数值型
        System.out.println(employee.toString());//路径@哈希值,16进制

        int[] arr=new int[0];
        System.out.println(arr.getClass().getName());//整个路径
        System.out.println(arr.getClass().getSimpleName());//类名
        System.out.println(arr.hashCode());//哈希值,数值型
        System.out.println(arr.toString());//路径@哈希值,16进制

        Employee employee2 =new Manager();//动态绑定,会先判断employee2属于Manager类型
        System.out.println(employee2.getClass().getName());//整个路径
        System.out.println(employee2.getClass().getSimpleName());//类名
        System.out.println(employee2.hashCode());//哈希值,数值型
        System.out.println(employee2.toString());//路径@哈希值,16进制
    }

}
