package com.tistory.jaimemin.effectivejava.ch04.item24.staticmemberclass;

import java.util.function.BiFunction;

public class Calculator {

	public enum Operation {

		PLUS(Integer::sum),
		MINUS((x, y) -> x - y),
		MULTIPLY((x, y) -> x * y),
		DIVIDE((x, y) -> x / y);

		private BiFunction<Integer, Integer, Integer> calculate;

		Operation(BiFunction<Integer, Integer, Integer> calculate) {
			this.calculate = calculate;
		}

		public BiFunction<Integer, Integer, Integer> getFunction() {
			return calculate;
		}
	}

	public int add(int x, int y) {
		return Operation.PLUS.getFunction().apply(x, y);
	}

	public int subtract(int x, int y) {
		return Operation.MINUS.getFunction().apply(x, y);
	}

	public int multiply(int x, int y) {
		return Operation.MULTIPLY.getFunction().apply(x, y);
	}

	public int divide(int x, int y) {
		return Operation.DIVIDE.getFunction().apply(x, y);
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int x = 4, y = 2;

		System.out.println(String.format("덧셈 결과: %s", calculator.add(x, y)));
		System.out.println(String.format("뺄셈 결과: %s", calculator.subtract(x, y)));
		System.out.println(String.format("곱셈 결과: %s", calculator.multiply(x, y)));
		System.out.println(String.format("나눗셈 결과: %s", calculator.divide(x, y)));
	}
}
