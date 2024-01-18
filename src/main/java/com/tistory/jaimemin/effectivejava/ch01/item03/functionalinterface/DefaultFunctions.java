package com.tistory.jaimemin.effectivejava.ch01.item03.functionalinterface;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.tistory.jaimemin.effectivejava.ch01.item03.methodreference.Person;

/**
 * 위 네 개 함수형 인터페이스만 알면 충분
 * 나머지는 다 파생되는 인터페이스
 */
public class DefaultFunctions {

	public static void main(String[] args) {
		Function<Integer, String> intToString = Object::toString;

		Supplier<Person> personSupplier = Person::new;
		Function<LocalDate, Person> personFunction = Person::new;

		Consumer<Integer> integerConsumer = System.out::println;

		Predicate<Person> predicate;
	}
}
