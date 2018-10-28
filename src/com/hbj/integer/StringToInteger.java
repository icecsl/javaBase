package com.hbj.integer;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/8/22
 */
public class StringToInteger {

	public static void main(String[] args) {

		/*Integer a = null;
 		if (a == 1){
			System.out.println(1);
		}else {

			System.out.println(a);

		}*/

//		integerToString();
//		integerToInt();
//		strToInteger();
//		longToInt();
		Integer a = null;
		if (a ==1){
			System.out.println("a");
		}
		else {
			System.out.println("b");
		}



	}

	public static void integerToString(){
		Integer a = null;

		String s = String.valueOf(a);
		System.out.println(s);
	}

	public static void integerToInt(){
		Integer a = null;

		int s = a;
		System.out.println(s);
	}

	public static void strToInteger(){

		Integer intTime = Integer.valueOf("a");

		System.out.println(intTime);
	}

	public static void longToInt(){
		Long a = null;

		String s = String.valueOf(a);
		System.out.println(s);
	}

	public static  Integer getSpendCoins(Integer a , Integer b){


		int needSpend = a > b?b : a;

		return needSpend;
	}
}
