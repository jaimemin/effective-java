package com.tistory.jaimemin.effectivejava.ch02.item03.functionalinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UsageOfFunctions {

	public static void main(String[] args) {
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(1982, 7, 15));
		dates.add(LocalDate.of(2011, 3, 2));
		dates.add(LocalDate.of(2013, 1, 28));

		List<Integer> before2000 = dates.stream()
			.filter(getLocalDatePredicate())
			.map(getGetYear())
			.collect(Collectors.toList());
	}

	/**
	 * 함수형 인터페이스들
	 * Predicate
	 * Function
	 */
	private static Predicate<LocalDate> getLocalDatePredicate() {
		return d -> d.isBefore(LocalDate.of(2000, 1, 1));
	}

	private static Function<LocalDate, Integer> getGetYear() {
		return LocalDate::getYear;
	}
}