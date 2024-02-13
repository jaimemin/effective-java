package com.tistory.jaimemin.effectivejava.ch02.item02.builder;

import java.util.Random;
import java.util.UUID;

public class Example {

	public static void main(String[] args) {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		int requiredField = random.nextInt();
		String requiredField2 = UUID.randomUUID().toString();
		Long optionalField = random.nextLong();

		RequiredBuilder requiredBuilder = RequiredBuilder.builder(requiredField, requiredField2)
			.optionalField(optionalField)
			.build();
		System.out.println(requiredBuilder);
	}
}
