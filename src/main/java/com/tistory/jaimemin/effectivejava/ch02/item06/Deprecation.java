package com.tistory.jaimemin.effectivejava.ch02.item06;

public class Deprecation {

	/**
	 * @deprecated in favor of
	 * {@link #Deprecation(String)}
	 * <p>
	 * java 9부터는 forRemoval = true 속성이 생겨서 좀 더 명시적으로 표시
	 */
	@Deprecated(forRemoval = true, since = "1.2")
	public Deprecation() {
	}

	private String name;

	public Deprecation(String name) {
		this.name = name;
	}
}