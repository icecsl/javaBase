package com.hbj.collection.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangbingjing on 18/1/25.
 */
public class HashMapTest {
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<>(7);
		hashMap.put("a","aa");
		hashMap.put("b","bb");
		hashMap.put("Aa","Aa");
		hashMap.put("BB","BB");
		hashMap.put("BB","CC");

		System.out.println(hashMap.get("a"));

		System.out.println(hashMap);
	}
}
