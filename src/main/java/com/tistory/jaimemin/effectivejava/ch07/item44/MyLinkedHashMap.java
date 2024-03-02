package com.tistory.jaimemin.effectivejava.ch07.item44;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLinkedHashMap extends LinkedHashMap<Integer, String> {

	private final int size;

	MyLinkedHashMap(int size) {
		this.size = size;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
		return size() > size;
	}

	public static void main(String[] args) {
		MyLinkedHashMap map = new MyLinkedHashMap(2);
		map.put(1, "하나");
		System.out.println(map);

		map.put(2, "둘");
		System.out.println(map);
		
		map.put(3, "셋");
		System.out.println(map);
	}
}
