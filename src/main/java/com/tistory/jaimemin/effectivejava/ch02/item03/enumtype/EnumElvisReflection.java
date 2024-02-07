package com.tistory.jaimemin.effectivejava.ch02.item03.enumtype;

import java.lang.reflect.Constructor;

public class EnumElvisReflection {

	public static void main(String[] args) {
		/**
		 * Enum 은 Constructor를 가져올 수 없음
		 *
		 * target 폴더 내 컴파일된 코드를 보면 생성자 있는 것을 확인 가능
		 */
		try {
			Constructor<Elvis> declaredConstructor = Elvis.class.getDeclaredConstructor();
			System.out.println(declaredConstructor);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}