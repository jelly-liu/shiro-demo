package com.jelly.shiroMySQLDemo.shiro;

import com.jelly.shiroMySQLDemo.model.TUser;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by jelly on 2016-10-18.
 */
public class MyUsernamePasswordToken extends UsernamePasswordToken {
    private TUser user;

    public MyUsernamePasswordToken(String username,String password) {
        super(username, password);
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    @Override
    public void clear() {
        super.clear();
        this.user = null;
    }
}
