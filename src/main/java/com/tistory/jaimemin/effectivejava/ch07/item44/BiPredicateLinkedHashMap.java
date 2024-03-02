package com.tistory.jaimemin.effectivejava.ch07.item44;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;

class BiPredicateLinkedHashMap extends LinkedHashMap<Integer, String> {

	private final BiPredicate<Map<Integer, String>, Map.Entry<Integer, String>> removalBiPredicate;

	BiPredicateLinkedHashMap(BiPredicate<Map<Integer, String>, Map.Entry<Integer, String>> removalBiPredicate) {
		this.removalBiPredicate = removalBiPredicate;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
		return removalBiPredicate.test(this, eldest);
	}

	public static void main(String[] args) {
		BiPredicateLinkedHashMap map = new BiPredicateLinkedHashMap(
			(m, eldest) -> m.size() > 2
		);
		map.put(1, "하나");
		System.out.println(map);

		map.put(2, "둘");
		System.out.println(map);

		map.put(3, "셋");
		System.out.println(map);
	}
}