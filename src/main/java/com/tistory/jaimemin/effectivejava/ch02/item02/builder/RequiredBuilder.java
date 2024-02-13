package com.tistory.jaimemin.effectivejava.ch02.item02.builder;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder(builderMethodName = "")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequiredBuilder {

	private int requiredField;

	private String requiredField2;

	private Long optionalField;

	@Builder.Default
	private List<String> list = new ArrayList<>();

	public static RequiredBuilderBuilder builder(int requiredField, String requiredField2) {
		return new RequiredBuilderBuilder()
			.requiredField(requiredField)
			.requiredField2(requiredField2);
	}
}
