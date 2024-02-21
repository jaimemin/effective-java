package com.tistory.jaimemin.effectivejava.ch05.item33.type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Favorites {

	private Map<Class<?>, Object> map = new HashMap<>();

	/**
	 * 컴파일 차원에서 favorites.put((Class)String.class, 1);을 막을 수 없음
	 * -> 악의적으로 raw 타입으로 넣어줄 때
	 * 넣을 때 타입 체킹을 해서 최대한 빨리 발견하자 (런타임 에러지만 서버 기동하자마자 에러)
	 *
	 *
	 */
	public <T> void put(Class<T> clazz, T value) {
		this.map.put(Objects.requireNonNull(clazz), clazz.cast(value));
	}

	public <T> T get(Class<T> clazz) {
		return clazz.cast(this.map.get(clazz));
	}

	public static void main(String[] args) {
		Favorites favorites = new Favorites();
		favorites.put(String.class, "jaimemin");
		favorites.put(Integer.class, 2);
		favorites.put(List.class, List.of(1, 2, 3));

		/**
		 * 아래와 같이 작성할 수 없음
		 * Class Literal은 List.class만 가능하며 타입을 가지는 List<Integer>.class를 가져올 수 없음
		 * 따라서 List<Integer>, List<String>을 구분할 수 없음
		 * -> 한 가지 방법이 있는데 Super Type Token
		 *
		 * favorites.put(List<Integer>.class, List.of(1, 2, 3));
		 * favorites.put(List<String>.class, List.of("a", "b", "c"));
		 *
		 * List list = favorites.get(List.class);
		 * list.forEach(System.out::println);
		 */
	}

}
