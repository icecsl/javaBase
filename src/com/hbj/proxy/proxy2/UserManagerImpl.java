package com.hbj.proxy.proxy2;

/**
 * Created by huangbingjing on 2016/7/20.
 */
public class UserManagerImpl implements UserManager {
    public void addUser(String userId, String userName) {
        System.out.println("UserManagerImpl.addUser");

    }

    public void delUser(String userId) {
        System.out.println("UserManagerImpl.delUser");

    }

    public String findUser(String userId) {
        System.out.println("UserManagerImpl.findUser");
        return "张三";
    }

    public void modifyUser(String userId, String userName) {
        System.out.println("UserManagerImpl.modifyUser");

    }
}
