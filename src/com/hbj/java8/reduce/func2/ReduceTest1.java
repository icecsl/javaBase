package com.hbj.java8.reduce.func2;

import java.util.stream.Stream;

/**
 * 带初始值的
 * Created by huangbingjing on 18/5/7.
 */
public class ReduceTest1 {
	public static void main(String[] args) throws Exception {
		int accResult = Stream.of(1, 2, 3, 4)
				.reduce(0 , (acc, item) -> {
					System.out.println("acc : "  + acc);
					acc += item;
					System.out.println("item: " + item);
					System.out.println("acc+ : "  + acc);
					System.out.println("--------");
					return acc;
				});
		System.out.println("accResult: " + accResult);
		System.out.println("--------");
	}
}
