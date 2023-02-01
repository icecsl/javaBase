package thinkingInJava.base_1.accesspermission.obj;

/**
 * @Author: huangbingjing
 * @DATE: 1/31/23
 */
public class AOnePackagePermission {

    public static void main(String[] args) {
        // eg2.2 同包下才能访问default对象
        APermission a = new APermission();
        a.defaultName = "defaultName";
    }
}
