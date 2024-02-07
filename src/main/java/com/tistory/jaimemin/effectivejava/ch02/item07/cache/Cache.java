package com.tistory.jaimemin.effectivejava.ch02.item07.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Cache<K, V> {
	private final Map<K, V> cacheMap = new ConcurrentHashMap<>();
	private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

	public void put(K key, V value) {
		cacheMap.put(key, value);
	}

	public V get(K key) {
		return cacheMap.get(key);
	}

	public void removeUnusedKeys() {
		// Implement your logic to identify and remove unused keys
		// For this example, we will remove keys that haven't been accessed in the last 5 seconds
		long expirationTime = System.currentTimeMillis() - 5000;
		cacheMap.entrySet().removeIf(entry -> ((CacheEntry)entry.getValue()).getLastAccessTime() < expirationTime);
	}

	public void startCleanupTask() {
		ScheduledFuture<?> cleanupTask = executorService.scheduleAtFixedRate(
			this::removeUnusedKeys,
			0, // initial delay
			1, // period
			TimeUnit.SECONDS
		);
	}

	// Helper class to store additional information for each cache entry
	private static class CacheEntry {
		private final long lastAccessTime;

		public CacheEntry() {
			this.lastAccessTime = System.currentTimeMillis();
		}

		public long getLastAccessTime() {
			return lastAccessTime;
		}
	}
}
