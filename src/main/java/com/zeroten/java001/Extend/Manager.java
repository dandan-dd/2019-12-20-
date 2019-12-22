package com.zeroten.java001.Extend;

import java.util.Date;

public class Manager extends Employee{

    private Integer bonus;

    public Manager(){
        System.out.println("执行Manager的无参构造方法");
    }
    public Manager(String name, Date hireDay,Integer salary,Integer bonus){
       super(name,hireDay,salary);
//        setName("经理1");
//        setHireDay(hireDay);
//        setSalary(salary);
        this.bonus=bonus;
        System.out.println("调用了Manager的有参构造方法");
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override    //子类覆盖父类，复写/覆盖，@Override
    public Integer getSalary(){
        if(bonus==null){
            return super.getSalary();//调用父类方法，用super关键字
        }
        return super.getSalary()+bonus;
    }

}
