package com.hbj.proxy.proxy2;

/**
 * Created by huangbingjing on 2016/7/20.
 */
public interface UserManager {
    public void addUser(String userId, String userName);
    public void delUser(String userId);
    public String findUser(String userId);
    public void modifyUser(String userId, String userName);
}
