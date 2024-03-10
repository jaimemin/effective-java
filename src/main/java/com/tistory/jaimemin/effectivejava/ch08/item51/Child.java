package com.tistory.jaimemin.effectivejava.ch08.item51;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString(callSuper = true)
public class Child extends Parent {

	private String childField;

	public static ChildBuilder<?, ?> builder(String requiredField) {
		return new ChildBuilderImpl().requiredField(requiredField);
	}

	private static class ChildBuilderImpl extends ChildBuilder<Child, ChildBuilderImpl> {
	}

	public static void main(String[] args) {
		// This will show a compilation error if parent's requiredField is not set
		Child child = Child.builder("requiredField")
			.childField("ChildField")
			.build();

		System.out.println(child);
	}
}
