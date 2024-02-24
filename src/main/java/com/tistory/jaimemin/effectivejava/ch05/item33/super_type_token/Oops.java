package com.tistory.jaimemin.effectivejava.ch05.item33.super_type_token;

import java.util.ArrayList;
import java.util.List;

class Oops {

	static Favorites2 f = new Favorites2();

	static <T> List<T> favoriteList() {
		TypeRef<List<T>> ref = new TypeRef<>() {
		};
		/**
		 * List<String>, List<Integer>로 구분될 것이라고 생각하지만
		 * List<T>가 출력됨
		 */
		System.out.println(ref.getType());

		List<T> result = f.get(ref);

		if (result == null) {
			result = new ArrayList<T>();
			f.put(ref, result);
		}

		return result;
	}

	/**
	 * ref.getType을 통해 얻은 타입이 둘 다 List<T>이기 때문에
	 * ClassCastException 발생 가능
	 * Super Type Token도 모든 상황에서 안전하지는 앟음
	 */
	public static void main(String[] args) {
		List<String> ls = favoriteList();
		List<Integer> li = favoriteList();
		li.add(1);

		for (String s : ls) {
			System.out.println(s);
		}
	}
}
