package com.tistory.jaimemin.effectivejava.ch07.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelPrimeCounting {
	// Prime-counting stream pipeline - parallel version (Page 225)
	static long parallelPi(long n) {
		return LongStream.rangeClosed(2, n)
			.parallel()
			.mapToObj(BigInteger::valueOf)
			.filter(i -> i.isProbablePrime(50))
			.count();
	}

	static long pi(long n) {
		return LongStream.rangeClosed(2, n)
			.mapToObj(BigInteger::valueOf)
			.filter(i -> i.isProbablePrime(50))
			.count();
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(parallelPi(10_000_000));
		long end = System.currentTimeMillis();
		System.out.println(String.format("parallelPi 메서드 실행 시간: %d", (end - start) / 1000));

		start = System.currentTimeMillis();
		System.out.println(pi(10_000_000));
		end = System.currentTimeMillis();
		System.out.println(String.format("pi 메서드 실행 시간: %d", (end - start) / 1000));
	}
}
