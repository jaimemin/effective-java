package com.tistory.jaimemin.effectivejava.ch08.item51;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@ToString
public class Parent {

	private final String requiredField;

	public static ParentBuilder<?, ?> builder(String requiredField) {
		return new ParentBuilderImpl().requiredField(requiredField);
	}

	private static class ParentBuilderImpl extends ParentBuilder<Parent, ParentBuilderImpl> {
	}
}
