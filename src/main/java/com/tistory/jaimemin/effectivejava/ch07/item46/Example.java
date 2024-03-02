package com.tistory.jaimemin.effectivejava.ch07.item46;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example {

	public static void main(String[] args) {
		String[] fruits = {"Apple", "Banana", "Orange", "Avocado", "Apricot"};

		// toList
		List<String> list = Arrays.stream(fruits)
			.collect(Collectors.toList());
		System.out.println(list);

		// toSet
		Set<String> set = Arrays.stream(fruits)
			.collect(Collectors.toSet());
		System.out.println(set);

		// toMap
		Map<Integer, String> map = IntStream.range(0, fruits.length)
			.boxed()
			.collect(Collectors.toMap(
				// 키: 배열의 인덱스
				index -> index,
				// 값: 배열의 값 (과일 이름)
				index -> fruits[index]
			));

		System.out.println(map);

		// joining
		String s = Arrays.stream(fruits)
			.collect(Collectors.joining(", "));

		System.out.println(s);

		// groupingBy
		Map<Integer, List<String>> groupedByLength = Arrays.stream(fruits)
			.collect(Collectors.groupingBy(String::length));

		System.out.println(groupedByLength);
	}
}
