package com.tistory.jaimemin.effectivejava.ch11.item80;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TaskExample {

	public static void main(String[] args) {
		// Runnable task
		Runnable runnableTask = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Runnable task executed by thread: " + threadName);
		};

		// Callable task
		Callable<Integer> callableTask = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Callable task executed by thread: " + threadName);
			// 작업 시뮬레이션을 위해 잠시 대기 후 결과 반환
			TimeUnit.SECONDS.sleep(2);

			return 123;
		};

		// ExecutorService 생성
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		// Runnable task 제출
		executorService.submit(runnableTask);

		// Callable task 제출 및 결과 획득
		Future<Integer> future = executorService.submit(callableTask);

		try {
			// 작업이 완료될 때까지 기다리고 결과 획득
			int result = future.get();
			System.out.println("Callable task result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// ExecutorService 종료
		executorService.shutdown();
	}
}
