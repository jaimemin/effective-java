package com.tistory.jaimemin.effectivejava.ch02.item06;

public class Sum {

	private static long slowSum() {
		Long sum = 0L;

		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}

		return sum;
	}

	private static long fastSum() {
		long sum = 0L;

		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}

		return sum;
	}

	private static String getDuration(long start, long end) {
		return (end - start) / 1_000_000. + " ms.";
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		long x = slowSum();
		long end = System.nanoTime();

		System.out.println(getDuration(start, end));
		System.out.println(x);

		start = System.nanoTime();
		x = fastSum();
		end = System.nanoTime();

		System.out.println(getDuration(start, end));
		System.out.println(x);
	}
}
