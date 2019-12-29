package com.zeroten.java001.proxy;

public class User2Dao {
    public boolean save(User user) {//如果声明为static/final ,就无法调用拦截器，直接调用输出方法
        System.out.println("保存用户："+user.getName()+","+user.getAge());
        return true;
    }

    public void query() {
    }
}
