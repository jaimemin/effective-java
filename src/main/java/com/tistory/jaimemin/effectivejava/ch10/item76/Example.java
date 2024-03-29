package com.tistory.jaimemin.effectivejava.ch10.item76;

import java.util.Map;
import java.util.TreeMap;

public class Example {

	public static void main(String[] args) {
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(1, "하나");
		treeMap.put(2, "둘");
		treeMap.put(3, "셋");

		System.out.println("실패 전: " + treeMap);

		try {
			// ClassCastException 발생 시도
			treeMap.put(4, (String)(Object)new Integer(4)); // 임의로 ClassCastException 유발
		} catch (ClassCastException e) {
			// 예외 처리
			System.out.println("ClassCastException occurred: " + e.getMessage());
		}

		System.out.println("실패 후: " + treeMap);
	}
}
