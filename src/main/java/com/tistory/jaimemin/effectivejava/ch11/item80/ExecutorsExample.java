package com.tistory.jaimemin.effectivejava.ch11.item80;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {

	public static void main(String[] args) {
		// 쓰레드 풀의 크기를 고정하고 두 개의 쓰레드로 이루어진 쓰레드 풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// 작업을 제출
		executorService.submit(() -> {
			try {
				System.out.println("Task 1 started by thread: " + Thread.currentThread().getName());
				// 작업 시뮬레이션을 위해 잠시 대기
				Thread.sleep(2000);
				System.out.println("Task 1 completed by thread: " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		executorService.submit(() -> {
			try {
				System.out.println("Task 2 started by thread: " + Thread.currentThread().getName());
				// 작업 시뮬레이션을 위해 잠시 대기
				Thread.sleep(1000);
				System.out.println("Task 2 completed by thread: " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		// 모든 작업이 완료될 때까지 대기
		executorService.shutdown();

		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

