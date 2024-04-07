package com.tistory.jaimemin.effectivejava.ch11.item80;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example {

	public static void main(String[] args) throws InterruptedException {
		// 1. newSingleThreadExecutor
		ExecutorService executor = Executors.newSingleThreadExecutor();

		// 2. execute
		executor.execute(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello from " + threadName);
		});

		try {
			// 4. get (Using Future)
			Future<String> futureResult = executor.submit(() -> {
				TimeUnit.SECONDS.sleep(2);
				return "Result of Task";
			});

			String result = futureResult.get();
			System.out.println("Task result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("Cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("Shutdown finished");
		}

		// 3. shutdown
		executor.shutdown();

		// 5. invokeAny, invokeAll
		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		try {
			Callable<String> task1 = () -> {
				TimeUnit.SECONDS.sleep(2);
				return "Result of Task1";
			};
			Callable<String> task2 = () -> {
				TimeUnit.SECONDS.sleep(1);
				return "Result of Task2";
			};

			String result = executor2.invokeAny(List.of(task1, task2));
			System.out.println("Result of invokeAny: " + result);

			// invokeAll
			executor2.invokeAll(List.of(task1, task2))
				.stream()
				.map(future -> {
					try {
						return future.get();
					} catch (Exception e) {
						throw new IllegalStateException(e);
					}
				})
				.forEach(System.out::println);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor2.shutdown();
		}

		// 6. awaitTermination
		ExecutorService executor3 = Executors.newSingleThreadExecutor();
		try {
			executor3.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (!executor3.isTerminated()) {
				executor3.shutdownNow();
			}
		}

		// 7. ExecutorCompletionService
		ExecutorService executor4 = Executors.newFixedThreadPool(3);
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor4);

		for (int i = 1; i <= 5; i++) {
			int task = i;

			completionService.submit(() -> task);
		}

		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(completionService.take().get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor4.shutdown();
		}

		// 8. ScheduledThreadPoolExecutor
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
		scheduledExecutor.schedule(() -> {
			System.out.println("Scheduled Task executed");
		}, 3, TimeUnit.SECONDS);
		scheduledExecutor.shutdown();
	}
}
