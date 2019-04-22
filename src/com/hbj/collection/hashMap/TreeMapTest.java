package com.hbj.collection.hashMap;

import java.util.TreeMap;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/1/22
 */
public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Integer, String> m = new TreeMap<>();
		m.put(1, "a");
		m.put(6, "x");
		m.put(5, "c");
		m.put(6, "t");

		System.out.println(m);

		KeyC a = new KeyC();
		System.out.println(m.get(a));
	}
}

class KeyC{

}
