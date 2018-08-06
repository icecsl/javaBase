package designMode.abstractFactory;

import designMode.abstractFactory.impl.SpringSkinFactory;

/**
 * 抽象工厂模式
 * Created by huangbingjing on 18/2/6.
 */
public class AbstractFactoryTest {

	public static void main(String[] args) {

		//这部分可以通过配置设定创建的是哪种skinFactory.
		SkinFactory skinFactory = new SpringSkinFactory();
//		SkinFactory skinFactory = new SummerSkinFactory();
		Button bt = skinFactory.createButton();
		TextField tf = skinFactory.createTextField();
		bt.display();
		tf.display();
	}
}
