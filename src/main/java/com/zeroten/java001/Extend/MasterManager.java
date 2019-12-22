package com.zeroten.java001.Extend;

import java.util.Date;

public class MasterManager extends Manager {

    @Override
    public String getName(){
        return "["+super.getName()+"]";
    }

    public MasterManager(String name, Date hireDay, Integer salary, Integer bonus){
        super(name,hireDay,salary,bonus);
//        setName("经理1");
//        setHireDay(hireDay);
//        setSalary(salary);
//        this.bonus=bonus;
        System.out.println("调用了MasterManager的有参构造方法");
    }

}
