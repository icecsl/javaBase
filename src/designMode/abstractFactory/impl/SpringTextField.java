package designMode.abstractFactory.impl;

import designMode.abstractFactory.TextField;

/**
 * Created by huangbingjing on 18/2/6.
 */
public class SpringTextField implements TextField {
	@Override
	public void display() {
		System.out.println("spring: 显示绿色边框文本框。");
	}
}
