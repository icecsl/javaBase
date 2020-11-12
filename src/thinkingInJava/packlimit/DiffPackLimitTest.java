package thinkingInJava.packlimit;

import thinkingInJava.packlimit.p1.DiffPackPo;

/**
 * @Author: huangbingjing
 * @DATE: 2020-11-10
 */
public class DiffPackLimitTest extends DiffPackPo {

    public static void main(String[] args) {

        // 不同包测试
        DiffPackPo pack1Po = new DiffPackPo();
        String name = pack1Po.name; // public
//        int age = pack1Po.age; // protect 不能访问
//        String nickName = pack1Po.nickName; // private 不能访问
//        boolean old = pack1Po.old; // default 不能访问

        // 不同包子类测试
        DiffPackLimitTest dsun = new DiffPackLimitTest();
        String nameS = dsun.name; // public
        int ageS = dsun.age; // protect
//        String nickNameS = dsun.nickName; // private 不能访问
//        boolean oldS = dsun.old; // default 不能访问

    }
}
