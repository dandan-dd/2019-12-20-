package com.zeroten.java001.proxy;

import java.awt.*;

public interface UserDao {

    boolean save(User user);
    List query();
}
