package designMode.simpleFactory.impl;

import designMode.simpleFactory.Shape;

/**
 * Created by huangbingjing on 18/2/5.
 */
public class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
