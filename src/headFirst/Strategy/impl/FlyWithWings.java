package headFirst.Strategy.impl;

import headFirst.Strategy.FlyBehavior;

/**
 * Created by huangbingjing on 2016/9/23.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i can fly");
    }
}
