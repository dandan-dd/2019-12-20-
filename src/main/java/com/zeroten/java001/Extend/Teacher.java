package com.zeroten.java001.Extend;

public class Teacher extends Person {
    @Override        //如果不实现父类中的抽象方法,就必须得重写方法
    public String getDescrition(){
        return "老师";
    }
}
