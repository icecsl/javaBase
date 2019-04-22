package com.hbj.proxy.proxy2;

/**
 * Created by huangbingjing on 2016/7/20.
 */
public class Client {

    public static void main(String[] args) throws Exception {

//        Field field = System.class.getDeclaredField("props");
//        field.setAccessible(true);
//        Properties props = (Properties) field.get(null);
//        props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        LogHandler logHandler=new LogHandler();
        UserManager userManager=(UserManager)logHandler.newProxyInstance(new UserManagerImpl());
        //UserManager userManager=new UserManagerImpl();
//        userManager.addUser("1111", "张三");
        userManager.delUser("1111");
    }
}
