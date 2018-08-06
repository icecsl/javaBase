package com.hbj.java8.reduce.func3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**操作对象
 * Created by huangbingjing on 18/5/7.
 */
public class ReduceTest {
	public static void main(String[] args) throws Exception {
		List<Foo> fooList = Arrays.asList(
				new Foo("A", "san", 1.0, 2),
				new Foo("A", "nas", 13.0, 1),
				new Foo("B", "san", 112.0, 3),
				new Foo("C", "san", 43.0, 5),
				new Foo("B", "nas", 77.0, 7)
		);
		List<Bar> barList = new ArrayList<>();
		fooList
				.stream()
				.collect(Collectors.groupingBy(Foo::getName, Collectors.toList()))
				.forEach((name, fooListByName) -> {
					Bar bar = new Bar();
					bar = fooListByName
							.stream()
							.reduce(bar, (u, t) -> u.sum(t), (u, t) -> u);
					System.out.println(bar.toString());
					barList.add(bar);
				});
	}
}
