package headFirst.Strategy;

import headFirst.Strategy.Duck;
import headFirst.Strategy.impl.FlyNoWay;
import headFirst.Strategy.impl.Quack;

/**
 * 模型鸭
 * Created by huangbingjing on 17/6/29.
 */
public class ModelDuck extends Duck {
	public ModelDuck() {
		// 一开始-不能飞，普通鸭子叫
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("I'm a model duck");
	}
}
