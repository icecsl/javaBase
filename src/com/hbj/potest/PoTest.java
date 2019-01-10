package com.hbj.potest;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/11/7
 */
public class PoTest {

	public static void main(String[] args) {
		PoClass po = new PoClass();

		PoClass newPo = modify(po);

		System.out.println(po == newPo);




	}

	public static PoClass modify(PoClass po){

		po.setName("hahhah");

		po = new PoClass();

		return po;

	}
}
