package com.tistory.jaimemin.effectivejava.ch02.item02.builder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@NoArgsConstructor
@SuperBuilder(builderMethodName = "")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Parent {

	@NonNull
	protected Integer a;

	protected int b;

}
