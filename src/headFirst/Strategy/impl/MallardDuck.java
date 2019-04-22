package headFirst.Strategy.impl;

import headFirst.Strategy.Duck;

/**
 * Created by huangbingjing on 2016/9/23.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {

        System.out.println("i am a Mallard Duck");
    }
}
