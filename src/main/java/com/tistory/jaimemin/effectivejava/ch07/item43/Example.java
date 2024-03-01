package com.tistory.jaimemin.effectivejava.ch07.item43;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Example {

	public static void main(String[] args) {
		// 정적 메서드
		BinaryOperator<Integer> methodReference = Integer::sum;
		BinaryOperator<Integer> lambdaExpression = (a, b) -> Integer.sum(a, b);

		// 한정적 인스턴스 메서드
		Instant then = Instant.now();
		Predicate<Instant> boundedMethodReference = Instant.now()::isAfter;
		Predicate<Instant> boundedLambdaExpression = t -> then.isAfter(t);

		// 비한정적 인스턴스 메서드
		Function<String, Integer> unboundedMethodReference = String::length;
		Function<String, Integer> unboundedLambdaExpression = s -> s.length();

		// 클래스 생성자
		Supplier<List<String>> constructorReference = ArrayList::new;
		Supplier<List<String>> constructorLambdaExpression = () -> new ArrayList<>();

		// 배열 생성자
		Function<Integer, int[]> arrayConstructorReference = int[]::new;
		Function<Integer, int[]> arrayConstructorLambdaExpression = size -> new int[size];
	}
}
