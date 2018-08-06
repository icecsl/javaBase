package com.hbj.string.split;

import java.util.Arrays;

/**
 * Created by huangbingjing on 17/11/14.
 */
public class SplitTest {
	public static void main(String[] args) {

		String s = "abcaabcaa";

		String[] p1 = s.split("a");//limit=0 匹配尽可能多的,结尾空的去掉
		String[] p2 = s.split("a",2);
		String[] p3 = s.split("a",-2);//limit<0 匹配尽可能多的,结尾空的不去掉
		String[] p4 = s.split("a",7);
		String[] p5 = s.split("a",-7);
//		String[] p6 = s.split("a");//limit=0 匹配尽可能多的,结尾空的去掉!!!
//		String[] p7 = s.split("a",-3);//limit<0 匹配尽可能多的,结尾空的不去掉,也就是一共有c+1个.
		display(p1);
		display(p2);
		display(p3);
		display(p4);
		display(p5);
//		display(p6);
//		display(p7);


	}

	private static void display(String[] p){
		System.out.println("长度:"+p.length);
		System.out.println("内容:"+ Arrays.toString(p));
	}
}
