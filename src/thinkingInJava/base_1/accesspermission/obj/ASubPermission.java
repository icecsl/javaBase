package thinkingInJava.base_1.accesspermission.obj;

/**
 * @Author: huangbingjing
 * @DATE: 1/31/23
 */
public class ASubPermission extends APermission {

    public static void main(String[] args) {
        // eg3 子类可以访问
        APermission a = new APermission();
        a.proName = "proName";
    }

}
