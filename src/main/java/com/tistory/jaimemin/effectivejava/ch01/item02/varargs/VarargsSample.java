package com.tistory.jaimemin.effectivejava.ch01.item02.varargs;

import java.util.Arrays;

public class VarargsSample {

	public void printNumbers(int ...numbers) {
		System.out.println(numbers.getClass().getCanonicalName());
		System.out.println(numbers.getClass().getComponentType());

		Arrays.stream(numbers).forEach(System.out::println);
	}

	/**
	 * 	Heap Pollution 공부해보기
	 */
	public static void main(String[] args) {
		VarargsSample samples = new VarargsSample();
		samples.printNumbers(5, 10);
	}
}
