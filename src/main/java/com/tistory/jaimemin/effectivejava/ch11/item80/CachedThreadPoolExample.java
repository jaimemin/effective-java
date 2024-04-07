package com.tistory.jaimemin.effectivejava.ch11.item80;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolExample {

	public static void main(String[] args) {
		// CachedThreadPool 생성
		ExecutorService executorService = Executors.newCachedThreadPool();

		// 작업을 제출
		for (int i = 0; i < 5; i++) {
			int taskNumber = i + 1;

			executorService.submit(() -> {
				System.out.println("Task " + taskNumber + " started by thread: " + Thread.currentThread().getName());

				// 작업 시뮬레이션을 위해 잠시 대기
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Task " + taskNumber + " completed by thread: " + Thread.currentThread().getName());
			});
		}

		// 모든 작업이 완료될 때까지 대기
		executorService.shutdown();

		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

