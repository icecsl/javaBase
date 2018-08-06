package designMode.abstractFactory.impl;

import designMode.abstractFactory.Button;

/**
 * Created by huangbingjing on 18/2/6.
 */
public class SpringButton implements Button {
	@Override
	public void display() {
		System.out.println("spring: 显示浅绿色按钮。");
	}
}
