package com.hbj.collection.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangbingjing on 18/1/25.
 */
public class ArrayListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(0);
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add(null);
		list.add(null);
		list.add(null);

		System.out.println(list);
	}
}
