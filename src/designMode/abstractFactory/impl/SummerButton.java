package designMode.abstractFactory.impl;

import designMode.abstractFactory.Button;

/**
 * Created by huangbingjing on 18/2/6.
 */
public class SummerButton implements Button {
	@Override
	public void display() {
		System.out.println("summer: 显示浅蓝色按钮。");

	}
}
