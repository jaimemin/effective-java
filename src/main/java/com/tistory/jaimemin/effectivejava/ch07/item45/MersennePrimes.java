package com.tistory.jaimemin.effectivejava.ch07.item45;

import static java.math.BigInteger.*;

import java.math.BigInteger;
import java.util.stream.Stream;

// Generating the first twent Mersenne primes using streams (Page 208)
public class MersennePrimes {
	static Stream<BigInteger> primes() {
		return Stream.iterate(TWO, BigInteger::nextProbablePrime);
	}

	public static void main(String[] args) {
		primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
			.filter(mersenne -> mersenne.isProbablePrime(50))
			.limit(20)
			.forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
	}
}
