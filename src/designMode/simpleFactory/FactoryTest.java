package designMode.simpleFactory;

/**
 * 简单工厂模式-并不是一个设计模式
 * Created by huangbingjing on 18/2/5.
 */
public class FactoryTest {

	public static void main(String[] args) {
		//创建一个工厂
		ShapeFactory shapeFactory = new ShapeFactory();

		//告诉工厂要的形状-RECTANGLE
		Shape shape2 = shapeFactory.getShape("RECTANGLE");//可以修改为读配置
		shape2.draw();

		//告诉工厂要的形状-SQUARE
		Shape shape3 = shapeFactory.getShape("SQUARE");
		shape3.draw();
	}
}
