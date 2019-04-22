package headFirst.Strategy.impl;

import headFirst.Strategy.QuackBehavior;

/**
 * Created by huangbingjing on 2016/9/23.
 */
public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("普通鸭子呱呱叫");
    }
}
