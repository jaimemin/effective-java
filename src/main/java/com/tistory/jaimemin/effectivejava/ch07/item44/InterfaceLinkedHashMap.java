package com.tistory.jaimemin.effectivejava.ch07.item44;

import java.util.LinkedHashMap;
import java.util.Map;

public class InterfaceLinkedHashMap extends LinkedHashMap<Integer, String> {

	private final EldestEntryRemovalFunction<Integer, String> removalFunction;

	InterfaceLinkedHashMap(EldestEntryRemovalFunction<Integer, String> removalFunction) {
		this.removalFunction = removalFunction;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
		return removalFunction.remove(this, eldest);
	}

	public static void main(String[] args) {
		InterfaceLinkedHashMap map = new InterfaceLinkedHashMap(
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
