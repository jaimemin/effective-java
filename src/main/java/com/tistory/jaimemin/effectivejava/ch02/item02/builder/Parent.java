package com.tistory.jaimemin.effectivejava.ch02.item02.builder;

import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@SuperBuilder(builderMethodName = "")
public class Parent {

	@NonNull
	protected Integer a;

	protected int b;

}
