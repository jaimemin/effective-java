package com.tistory.jaimemin.effectivejava.ch05.item26.raw;

public class UseRawType<E> {

	private E e;

	public static void main(String[] args) {
		/**
		 * UseRawType<Integer>.class로 못함
		 * 오로지 Raw Type의 클래스만 있음
		 */
		System.out.println(UseRawType.class);

		UseRawType<String> stringType = new UseRawType<>();

		/**
		 * 원하면 instanceof UseRawType<String> 가능하지만 어차피 소거됨
		 * 추가하면 오히려 코드를 장황하게 만들어 가독성 저하
		 */
		System.out.println(stringType instanceof UseRawType);
	}
}
