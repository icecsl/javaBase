package com.hbj.proxy;

import java.util.Arrays;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/10/23
 */
public class Test {

	public static void main(String[] args) {
		showInterfacesFor(BaseClass.class);
		showInterfacesFor(Class1.class);
		showInterfacesFor(Class2.class);

	}

	private static void showInterfacesFor(Class<?> clazz) {
		System.out.printf("%s --> %s\n", clazz, Arrays.toString(clazz
				.getInterfaces()));
	}
}
