package com.tistory.jaimemin.effectivejava.ch10.item71;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Example {

	private static final Map<Long, String> repository = new HashMap<>();

	public static Optional<Object> findByIdOptional(long id) {
		if (id < 1L) {
			return Optional.empty();
		}

		return Optional.of(repository.get(id));
	}

	public static String findByIdCheckedException(long id) {
		if (id < 1L) {
			throw new IllegalArgumentException("id는 1 이상이어야 합니다.");
		}

		return repository.get(id);
	}

	public static void main(String[] args) {
		String s = (String)findByIdOptional(0L).orElse("예외 상황");
		System.out.println(s);
	}
}
