package headFirst.Strategy.impl;

import headFirst.Strategy.QuackBehavior;

/**
 * Created by huangbingjing on 2016/9/23.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不叫");
    }
}
