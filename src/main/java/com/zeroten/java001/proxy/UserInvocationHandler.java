package com.zeroten.java001.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserInvocationHandler implements InvocationHandler {

    public Object object;

    public UserInvocationHandler(Object object){
        this.object=object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(args!=null&&args.length==1){
            if (args[0] instanceof User){
                System.out.println("参数一是User");
                User user=(User) args[0];
                if(user.getName()==null||user.getName().trim().length()==0){
                    System.out.println("姓名为空，不保存");
                    return false;
                }
                if(user.getAge()==null||user.getAge()<0){
                    System.out.println("年龄小于0，不保存");
                    return false;
                }
            }
        }
        Object result=method.invoke(object,args);
        return result;
    }
}
