package com.tistory.jaimemin.effectivejava.ch01.item07.cache;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

/**
 * Key를 Integer가 아닌 CacheKey와 같은 레퍼런스로 만드는 이유
 * Integer나 String 혹은 primitive 타입을 키로 사용할 경우 JVM 내부에 캐싱
 * 값을 레퍼런스하는 변수를 null로 만들어도 strong reference가 남아있다고 생각해서 남아있음
 * <p>
 * CacheKey의 경우 GC 돌릴 경우 사라짐
 * 허나 Integer를 키로 하면 GC 돌릴 경우 생존
 */
class PostRepositoryTest {

	// WeakHashMap 이 아닌 HashMap 일 경우 테스트 통과 못 함
	@Test
	void cache() throws InterruptedException {
		PostRepository postRepository = new PostRepository();
		// Integer key1 = 1;
		CacheKey key1 = new CacheKey(1); // CacheKey라는 인스턴스가 이 테스트 메서드가 끝날 때까지 유효
		postRepository.getPostById(key1);

		assertFalse(postRepository.getCache().isEmpty());

		key1 = null; // 따라서 해당 키의 참조를 끊어내야 테스트 통과
		// run gc
		System.out.println("run gc");
		System.gc(); // 보장은 안되지만 실행은 됨
		System.out.println("wait");
		Thread.sleep(3000L);

		assertTrue(postRepository.getCache().isEmpty());
	}

	// TODO: LRU 캐시 구현해보자
	// 백그라운드 쓰레드를 사용해서 메모리 누수 막기
	@Test
	void backgroundThread() throws InterruptedException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		PostRepository postRepository = new PostRepository();

		for (int i = 0; i < 5; i++) {
			CacheKey key = new CacheKey(i);
			postRepository.getPostById(key);
		}

		Runnable removeOldCache = () -> {
			System.out.println("running removeOldCache task");
			Map<CacheKey, Post> cache = postRepository.getCache();
			Set<CacheKey> cacheKeys = cache.keySet();
			Optional<CacheKey> key = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));

			key.ifPresent((k) -> {
				System.out.println("removing " + k);

				cache.remove(k);
			});
		};

		System.out.println("The time is : " + new Date());

		executor.scheduleAtFixedRate(removeOldCache,
			1, 3, TimeUnit.SECONDS);

		Thread.sleep(30000L);

		executor.shutdown();
	}
}