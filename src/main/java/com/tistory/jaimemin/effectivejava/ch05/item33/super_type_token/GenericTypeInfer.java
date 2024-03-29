package com.tistory.jaimemin.effectivejava.ch05.item33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 상속을 사용해서 제네릭을 사용했을 때 제네릭 타입을 알아낼 수 있는 방법이기 때문에
 * Super Type Token
 */
public class GenericTypeInfer {

	static class Super<T> {
		T value;
	}

	public static void main(String[] args) throws NoSuchFieldException {
		Super<String> stringSuper = new Super<>();
		/**
		 * 클래스가 가지고 있는 필드의 타입을 꺼내보면 Object가 나옴
		 * 제네릭은 컴파일할 때 Object로 치환되고 T로 CASTCLASS
		 */
		System.out.println(stringSuper.getClass().getDeclaredField("value").getType());

		// 상속을 받을 경우 타입을 알 수 있음
		Type type = (new Super<String>() {
		}).getClass().getGenericSuperclass();
		ParameterizedType pType = (ParameterizedType)type;
		Type actualTypeArgument = pType.getActualTypeArguments()[0];
		System.out.println(actualTypeArgument);

	}
}
