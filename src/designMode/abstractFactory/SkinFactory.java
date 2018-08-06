package designMode.abstractFactory;

/**
 * 抽象工厂-界面皮肤工厂
 * Created by huangbingjing on 18/2/6.
 */
public interface SkinFactory {

	//皮肤工厂能创建按钮
	Button createButton();

	//能创建文本框
	TextField createTextField();
}
