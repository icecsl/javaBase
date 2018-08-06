package com.hbj.java8.reduce.func1;

import java.util.Optional;
import java.util.stream.Stream;

/**无初始值
 * Created by huangbingjing on 18/5/7.
 */
public class ReduceTest1 {
	public static void main(String[] args) throws Exception {
		Optional accResult = Stream.of(1, 2, 3, 4)
				.reduce((acc, item) -> {
					System.out.println("acc : "  + acc);
					acc -= item;
					System.out.println("item: " + item);
					System.out.println("acc+ : "  + acc);
					System.out.println("--------");
					return acc;
				});
		System.out.println("accResult: " + accResult.get());
		System.out.println("--------");
	}
}
