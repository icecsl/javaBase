package headFirst.Strategy;

import headFirst.Strategy.impl.FlyNoWay;
import headFirst.Strategy.impl.MallardDuck;
import headFirst.Strategy.impl.RedheadDuck;

/**
 * 策略模式
 * Created by huangbingjing on 2016/9/23.
 */
public class Test {

    public static void main(String[] args) {
        Duck redDuck =new RedheadDuck();
        redDuck.performFly();
        redDuck.performQuack();

        redDuck.setFlyBehavior(new FlyNoWay());
        redDuck.performFly();

        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

    }
}
