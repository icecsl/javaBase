package com.hbj.variableparam;

/**
 * @Description: 可变参数 object...
 * @author: huangbingjing
 * @date: 18/11/8
 */
public class VariableParamTest {
	public static void main(String[] args) {
		//一个长度为0的数组
		//Validator.validate();

		//Validator.validate("A", 3, new BigDecimal("2389"));
		//参数本身是数组，就不转化了
		Validator.validate(new Integer[]{22,4});
		Validator.validate(new Integer[]{22,4}, "3");
	}
}
