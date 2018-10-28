package com.hbj.proxy;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/10/23
 */
public class BaseClass implements MyInterface{
	@Override
	public void foo() {
		System.out.println("BaseClass.foo");
	}

	@Override
	public void superFoo() {

	}
}
