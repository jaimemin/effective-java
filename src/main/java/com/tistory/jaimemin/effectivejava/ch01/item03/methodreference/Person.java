package com.tistory.jaimemin.effectivejava.ch01.item03.methodreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

	LocalDate birthday;

	/**
	 * 임의 객체 인스턴스 메서드 레퍼런스일 경우 자기 자신이 첫 번째 매개변수
	 */
	// public int compareByAge(Person b) {
	// 	return this.birthday.compareTo(b.birthday);
	// }
	public Person() {

	}

	public Person(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return LocalDate.now().getYear() - birthday.getYear();
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public static void main(String[] args) {
		// 생성자 레퍼런스
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(1982, 7, 15));
		dates.add(LocalDate.of(1982, 7, 15));
		dates.add(LocalDate.of(1982, 7, 15));
		dates.stream()
			.map(Person::new)
			.collect(Collectors.toList());
		// 생성자 레퍼런스

		List<Person> people = new ArrayList<>();
		people.add(new Person(LocalDate.of(1982, 7, 15)));
		people.add(new Person(LocalDate.of(2011, 3, 2)));
		people.add(new Person(LocalDate.of(2013, 1, 28)));

		people.sort(new Comparator<Person>() {
			@Override
			public int compare(Person a, Person b) {
				return a.birthday.compareTo(b.birthday);
			}
		});
		/**
		 * 스태틱 메서드 레퍼런스
		 * Comparator 에 호환되는 메서드
		 */
		people.sort(Person::compareByAge);
		/**
		 * 인스턴스 메서드 레퍼런스
		 */
		// Person person = new Person(null);
		// people.sort(person::compareByAge); // compareByAge가 static이 아니라고 가정
	}
}
