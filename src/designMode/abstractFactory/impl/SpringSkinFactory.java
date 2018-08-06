package designMode.abstractFactory.impl;

import designMode.abstractFactory.Button;
import designMode.abstractFactory.SkinFactory;
import designMode.abstractFactory.TextField;

/**
 * spring的抽象工厂实现类
 * Created by huangbingjing on 18/2/6.
 */
public class SpringSkinFactory implements SkinFactory {

	//创建的是带spring皮肤的按钮
	@Override
	public Button createButton() {
		return new SpringButton();
	}

	//创建的是带spring皮肤的文本框
	@Override
	public TextField createTextField() {
		return new SpringTextField();
	}
}
