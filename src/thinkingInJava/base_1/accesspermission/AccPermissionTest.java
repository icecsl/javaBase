package thinkingInJava.base_1.accesspermission;

import thinkingInJava.base_1.accesspermission.obj.APermission;

/**
 * 说明:操作对象:APermission
 * 一共4个例子说明public、default、protected、private访问权限
 * 其中default(AOnePackagePermission)、protected(ASubPermission)、private(APermission)中说明
 *
 * @Author: huangbingjing
 * @DATE: 1/31/23
 */
public class AccPermissionTest {
    public static void main(String[] args) {

        APermission a = new APermission();
        // eg1. 只能操作a的public对象
        a.pubName = "pubName";

        // eg2.1 不同包下不能访问default对象
        // a.defaultName = "defaultName";

        // eg3 非子类不能访问protected对象
        // a.proName = "proName";

        // eg4 不能访问private对象
        // a.priName = "priName";
    }
}
