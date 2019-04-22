package headFirst.Strategy.impl;

import headFirst.Strategy.Duck;

/**
 * Created by huangbingjing on 2016/9/23.
 */
public class RedheadDuck extends Duck {

    public RedheadDuck() {

        quackBehavior= new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("i am a red duck");
    }
}
