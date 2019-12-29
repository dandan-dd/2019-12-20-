package com.zeroten.java001.proxy;

import java.lang.reflect.Proxy;

/**
 * 业务服务层Service
 * 基于接口来做时：
 * 接口命名以Service为后缀
 * 接口实现命名以ServiceImpl为后缀
 */
public class UserService {

    public static void directCall(){
        User user1=new User("张三,",16);
        new UserDaoImpl().save(user1);

        User user2=new User(",",18);
        new UserDaoImpl().save(user2);

        User user3=new User("张三,",-10);
        new UserDaoImpl().save(user3);
    }

    public static void staticProxyCall(){
        User user1=new User("张三,",10);
        UserDao userDao=new UserDaoImpl();
        UserDaoProxy proxy=new UserDaoProxy(userDao);
        proxy.save(user1);
    }

    public static void jdkProxyCall(){
        User user1=new User("张三,",-10);
        UserDao userDao=new UserDaoImpl();
        UserInvocationHandler handler=new UserInvocationHandler(userDao);
        UserDao userDaoProxy=(UserDao) Proxy.newProxyInstance(
                userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),
                handler
        );
        userDaoProxy.save(user1);
        userDaoProxy.query();//接口中发送变化，可以直接调用执行，代理类不需要修改
    }
    public static void jdkProxyCall2(){
        User user=new User("张三,",-60);
        User2Dao user2Dao=new User2Dao();
        UserInvocationHandler handler=new UserInvocationHandler(user2Dao);
        User2Dao user2DaoProxy=(User2Dao) Proxy.newProxyInstance(
                user2Dao.getClass().getClassLoader(),
                user2Dao.getClass().getInterfaces(),
                handler
        );
        user2DaoProxy.save(user);
        user2DaoProxy.query();//接口中发送变化，可以直接调用执行，代理类不需要修改
    }

    public static void cglibProxyCall(){
        User user=new User("张三,",-1111);
        User2Dao user2Dao=new User2Dao();
        User2DaoCgligProxy cglibProxy=new User2DaoCgligProxy(user2Dao);
        User2Dao user2DaoProxy=(User2Dao) cglibProxy.getProxyInstance();
        user2DaoProxy.save(user);

        UserDao userDao=new UserDaoImpl();
        User2DaoCgligProxy cglibProxy2=new User2DaoCgligProxy(userDao);
        UserDao userDaoProxy=(UserDao)cglibProxy2.getProxyInstance();
        userDaoProxy.save(user);

    }

    public static void main(String[] args){

        System.out.println("===============================直接调用=================================");
        //直接调用
        directCall();


        System.out.println("===============================静态代理=================================");
        //静态代理,当接口发送变化时，代理对象和目标对象需要同时实现被改变的接口。如果是动态代理，可以不用因为接口的改变而改变
        staticProxyCall();


        System.out.println("===============================动态代理=================================");
        //动态代理，JDK代理
        jdkProxyCall();


        System.out.println("======================被代理对象不是基于接口实现========================");
        //jdkProxyCall2();//必须是接口
        System.out.println("======================被代理对象必须是基于接口===========================");

        //Cglib代理Cglib,因为它通过子类方式来实现，所以也称为子类代理
        System.out.println("===============================子类代理=================================");
        cglibProxyCall();
    }

}
