package thinkingInJava.base_1.accesspermission.obj;

/**
 * @Author: huangbingjing
 * @DATE: 1/31/23
 */
public class APermission {

    /**
     * 所有对象都可以访问
     */
    public String pubName;

    /**
     * 只有子类可以访问
     */
    protected String proName;

    /**
     * 同一个包下可以访问，其他包的不可以访问
     */
    String defaultName;

    /**
     * 只有自己能访问
     */
    private String priName;


    /**
     * 操作private属性对象
     */
    private void operatePrivateField(){
        this.priName = "priName";
    }
}
