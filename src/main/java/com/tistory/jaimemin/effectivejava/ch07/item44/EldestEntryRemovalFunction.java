package com.tistory.jaimemin.effectivejava.ch07.item44;

import java.util.Map;

public interface EldestEntryRemovalFunction<K, V> {

	boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);
}
