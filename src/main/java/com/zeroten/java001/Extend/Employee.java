package com.zeroten.java001.Extend;

import org.testng.annotations.Test;

import java.util.Date;

public class Employee implements java.lang.Cloneable{

    //若需要防止被继承或者重写,可加上final修饰符

    private String name;//其子类无法调用,需要使用下面的getter\getter方法
    private Date hireDay;
    private Integer salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee(){
        System.out.println("执行Employee的无参构造器");
    }

    public Employee(String name,Date hireDay,Integer salary){
        this.name=name;
        this.hireDay=hireDay;
        this.salary=salary;
        System.out.println("调用了Employee的有参构造器");
    }

    public void printInfo(){
        StringBuilder tmp=new StringBuilder();
        tmp.append("姓名：");
        tmp.append(getName());
        tmp.append(",入职时间：");
        tmp.append(getHireDay());
        tmp.append(",薪水标准：");
        tmp.append(getSalary());

        System.out.println(tmp.toString());

    }

    @Test
    public Employee clone() throws CloneNotSupportedException{
        return (Employee)super.clone();
    }
}
