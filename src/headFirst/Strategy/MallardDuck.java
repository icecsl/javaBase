package headFirst.Strategy;

import headFirst.Strategy.Duck;
import headFirst.Strategy.impl.FlyWithWings;
import headFirst.Strategy.impl.Quack;

/**
 * 绿头鸭
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
