package com.tistory.jaimemin.effectivejava.ch11.item80;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

	static class SumTask extends RecursiveTask<Long> {

		private static final int THRESHOLD = 1000;

		private final long[] array;

		private final int start;

		private final int end;

		SumTask(long[] array, int start, int end) {
			this.array = array;
			this.start = start;
			this.end = end;
		}

		@Override
		protected Long compute() {
			if (end - start <= THRESHOLD) {
				long sum = 0;

				for (int i = start; i < end; i++) {
					sum += array[i];
				}

				return sum;
			} else {
				int mid = (start + end) >>> 1;
				SumTask leftTask = new SumTask(array, start, mid);
				SumTask rightTask = new SumTask(array, mid, end);
				leftTask.fork();
				long rightResult = rightTask.compute();
				long leftResult = leftTask.join();

				return leftResult + rightResult;
			}
		}
	}

	public static void main(String[] args) {
		long[] array = new long[1000000000];

		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

		long start = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		long result = forkJoinPool.invoke(new SumTask(array, 0, array.length));
		System.out.println("합: " + result);
		long end = System.currentTimeMillis();
		System.out.println(String.format("ForkJoinPool 실행시간: %d", (end - start)));

		start = System.currentTimeMillis();
		long sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		end = System.currentTimeMillis();
		System.out.println("합: " + sum);
		System.out.println(String.format("단순 반복문 실행시간: %d", (end - start)));
	}
}

