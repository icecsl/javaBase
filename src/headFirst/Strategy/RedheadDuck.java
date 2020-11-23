package headFirst.Strategy;

import headFirst.Strategy.Duck;
import headFirst.Strategy.impl.FlyWithWings;
import headFirst.Strategy.impl.Quack;

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
