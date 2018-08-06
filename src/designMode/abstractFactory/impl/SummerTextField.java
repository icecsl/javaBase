package designMode.abstractFactory.impl;

import designMode.abstractFactory.TextField;

/**
 * Created by huangbingjing on 18/2/6.
 */
public class SummerTextField implements TextField {
	@Override
	public void display() {
		System.out.println("summer: 显示蓝色边框文本框。");
	}
}
