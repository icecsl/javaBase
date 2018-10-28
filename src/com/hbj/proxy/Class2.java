package com.hbj.proxy;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/10/23
 */
public class Class2 extends BaseClass implements MyInterface, SuperInterface{

	@Override
	public void foo() {
		super.foo();
		System.out.println("Class2.foo");
	}

}
