package com.tistory.jaimemin.effectivejava.ch02.item02.builder;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class Child extends Parent {

	private int c;

	private int d;

	private int e;

	public static void main(String[] args) {
		Child child = Child.builder()
			.b(2)
			.c(3)
			.d(4)
			.e(5)
			.build();

		System.out.println(child);
	}
}
