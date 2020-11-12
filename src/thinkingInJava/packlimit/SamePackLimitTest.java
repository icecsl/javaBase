package thinkingInJava.packlimit;

/**
 * @Author: huangbingjing
 * @DATE: 2020-11-10
 */
public class SamePackLimitTest extends SamePackPo {

    public static void main(String[] args) {

        // 相同包测试
        SamePackPo pack1Po = new SamePackPo();
        String name = pack1Po.name; // public
        int age = pack1Po.age; // protect
//        String nickName = pack1Po.nickName; // private 不能访问
        boolean old = pack1Po.old; // default


        // 相同包子类测试
        SamePackLimitTest dsun = new SamePackLimitTest();
        String nameS = dsun.name; // public
        int ageS = dsun.age; // protect
//        String nickNameS = dsun.nickName; // private 不能访问
        boolean oldS = dsun.old; // default

    }
}
