package com.zeroten.java001.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class User2DaoCgligProxy implements MethodInterceptor {

    private  Object object;
    public User2DaoCgligProxy(Object object){
        this.object=object;
    }
    public Object getProxyInstance(){
        Enhancer en=new Enhancer();
        en.setSuperclass(object.getClass());//设置父类
        en.setCallback(this);//设置回调
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result=method.invoke(object,objects);
        return null;
    }
}
