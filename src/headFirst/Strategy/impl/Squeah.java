package headFirst.Strategy.impl;

import headFirst.Strategy.QuackBehavior;

/**
 * Created by huangbingjing on 2016/9/23.
 */
public class Squeah implements QuackBehavior {
    public void quack() {
        System.out.println("橡皮鸭吱吱叫");
    }
}
