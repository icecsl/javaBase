package com.hbj.common;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/12/26
 */
public class CastTest {
	private static int a;

	public static void main(String[] args) {

		System.out.println(a);
		CastBase base = new CastBase();
		base.echo();

		CastBaseSub castBase = (CastBaseSub)base;
//		castBase.echo();
//		castBase.subEcho();



	}
}
