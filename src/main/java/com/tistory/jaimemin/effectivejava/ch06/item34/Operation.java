package com.tistory.jaimemin.effectivejava.ch06.item34;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

// Enum type with constant-specific class bodies and data (Pages 163-4)
public enum Operation {
	PLUS("+") {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		public double apply(double x, double y) {
			return x / y;
		}
	};

	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public abstract double apply(double x, double y);

	// Implementing a fromString method on an enum type (Page 164)
	private static final Map<String, Operation> stringToEnum =
		Stream.of(values()).collect(
			toMap(Object::toString, e -> e));

	// Returns Operation for string, if any
	public static Optional<Operation> fromString(String symbol) {
		return Optional.ofNullable(stringToEnum.get(symbol));
	}

	public static Operation inverse(Operation op) {
		switch (op) {
			case PLUS:
				return Operation.MINUS;
			case MINUS:
				return Operation.PLUS;
			case TIMES:
				return Operation.DIVIDE;
			case DIVIDE:
				return Operation.TIMES;
			default:
				throw new AssertionError("알 수 없는 연산: " + op);
		}
	}

	public static void main(String[] args) {
		double x = 2.0;
		double y = 4.0;

		for (Operation op : Operation.values()) {
			System.out.printf("%f %s %f = %f%n",
				x, op, y, op.apply(x, y));
		}
	}
}