package com.tistory.jaimemin.effectivejava.ch07.item48;

import static java.math.BigInteger.*;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class ParallelMersennePrimesTest {

	static Stream<BigInteger> primes() {
		return Stream.iterate(TWO, BigInteger::nextProbablePrime);
	}

	@Test
	public void mersennePrimes() {
		long start = System.currentTimeMillis();

		primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
			.filter(mersenne -> mersenne.isProbablePrime(50))
			.limit(20)
			.forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));

		long end = System.currentTimeMillis();
		System.out.println(String.format("실행 시간: %d초", (end - start) / 1000));
	}

	@Test
	public void parallelMersennePrimes() {
		long start = System.currentTimeMillis();
		primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
			.parallel()
			.filter(mersenne -> mersenne.isProbablePrime(50))
			.limit(20)
			.forEach(System.out::println);

		long end = System.currentTimeMillis();
		System.out.println(String.format("실행 시간: %d초", (end - start) / 1000));
	}
}