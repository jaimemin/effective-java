package com.tistory.jaimemin.effectivejava.ch01.item07.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Thread 를 많이 만들어야 하는 경우 -> 시스템 리소스를 너무 많이 잡아먹음
 * Thread 를 좀 덜 만들고 동일한 작업을 할 수 있으려면 ThreadPool 을 활용 (ExecutorService)
 * <p>
 * -> ThreadPool 의 개수를 신경써야함
 * 1. CPU에 집중적인 작업이냐 (CPU Burst) -> CPU 개수만큼 만들면 됨 (Runtime.getRuntime().availableProcessors())
 * 2. IO에 집중적인 작업이냐 (IO Burst) -> I/O 기다리느라 대기할 수 있는 상황이기 때문에 CPU 개수보다 많게 쓰레드 풀 개수를 잡아야 함
 * -> 답이 없는 문제, 적절한 thread 수 파악을 위한 튜닝이 필요함
 */
public class ExecutorsExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10); // blocking queue
		// 반면 newCachedThreadPool()은 작업 환경이 하나이기 때문에 thread를 무한정 늘릴 수 있는 문제점
		Future<String> submit = service.submit(new Task());

		System.out.println(Thread.currentThread() + " hello");
		System.out.println(submit.get()); // 여기서부터 block (get은 blocking method)

		service.shutdown();
	}

	static class Task implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(2000L);

			return Thread.currentThread() + " world";
		}
	}

}
