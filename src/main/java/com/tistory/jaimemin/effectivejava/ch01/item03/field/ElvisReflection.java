package com.tistory.jaimemin.effectivejava.ch01.item03.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 생성자로 여러 인스턴스 만들기
 * 싱글톤 허점: Reflection 사용하면 싱글톤 깨짐
 */
public class ElvisReflection {

	public static void main(String[] args) {
		try {
			Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor(); // 기본 생성자 접근 (접근 지시자와 상관없이 접근 가능)
			defaultConstructor.setAccessible(true); // private 생성자는 이렇게 accessible true 로 설정 필요
			Elvis.INSTANCE.sing();
			Elvis elvis1 = defaultConstructor.newInstance();
			Elvis elvis2 = defaultConstructor.newInstance();
		} catch (InvocationTargetException
				 | NoSuchMethodException
				 | InstantiationException
				 | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
