/*
* HashMapTest.java Created On 2019年12月13日
* Copyright(c) 2019 Mazan Inc.
* ALL Rights Reserved.
*/
package io.github.mzanthem.leetcodetraining.test;

import java.util.HashMap;
import java.util.Map;

/**
* HashMapTest
*
* @time: 上午11:21:53
* @author mazan
*/
public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "A");
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("key:" + key + " , value :" + value);
			
		}

		int cap = 13;
		int n = cap - 1;
		int n1 = (n >>> 1);
		int n11 = n |= n1;
		System.out.println(n11);

		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		System.out.println(n);
	}

}
