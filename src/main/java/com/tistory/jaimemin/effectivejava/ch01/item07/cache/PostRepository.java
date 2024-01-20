package com.tistory.jaimemin.effectivejava.ch01.item07.cache;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * WeakHashMap 은 Weak Reference 를 Key 로 갖는 Map
 * Key 가 더 이상 참조되지 않으면 GC로 인해 key-value 모두 날라감
 * <p>
 * WeakHashMap과 Weak Reference에 대해 알아보기
 */
public class PostRepository {

	private Map<CacheKey, Post> cache;

	public PostRepository() {
		this.cache = new WeakHashMap<>();
	}

	public Post getPostById(CacheKey key) {
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else {
			// DB에서 읽어오거나 REST API를 통해 읽어올 수 있습니다.
			Post post = new Post();
			cache.put(key, post);
			return post;
		}
	}

	public Map<CacheKey, Post> getCache() {
		return cache;
	}
}