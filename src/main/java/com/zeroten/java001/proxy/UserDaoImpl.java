package com.zeroten.java001.proxy;

import java.awt.*;

/**
 * 数据库操作
 */
public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(User user){
        System.out.println("保存用户："+user.getName()+user.getAge());
        return true;
    }

    @Override
    public List query() {
        System.out.println("列表");
        return null;
    }
}
