package com.hbj.collection.hashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/1/21
 */
public class LinkedHashMapTest {
	public static void main(String[] args) {
//		Map<Integer, String> m = new LinkedHashMap<>(8,6, true);
		Map<Integer, String> m = new LinkedHashMap<>();
		m.put(4, "string4");
		m.put(2, "string2");
		m.put(3, "string3");
//		m.put(null, null);
		m.put(6, "string6");
		m.put(3, "string33");


		System.out.println(m);

		String s2 = m.get(2);
		System.out.println(m);
	}
}
