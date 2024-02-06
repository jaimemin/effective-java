package com.tistory.jaimemin.effectivejava.ch02.item14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person implements Comparable<Person>, Comparator<Person> {

	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person other) {
		// Comparable: Compare based on age
		return Integer.compare(this.age, other.age);
	}

	@Override
	public int compare(Person person1, Person person2) {
		// Comparator: Compare based on name length
		return Integer.compare(person1.getName().length(), person2.getName().length());
	}

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("John", 25));
		people.add(new Person("Alice", 30));
		people.add(new Person("Bob", 22));

		System.out.println("Before sorting:");

		for (Person person : people) {
			System.out.println(person.getName() + " - Age: " + person.getAge());
		}

		// Sorting using Comparable (age)
		Collections.sort(people);
		System.out.println("\nAfter sorting using Comparable (age):");

		for (Person person : people) {
			System.out.println(person.getName() + " - Age: " + person.getAge());
		}
	}
}

