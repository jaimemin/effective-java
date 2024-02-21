package com.tistory.jaimemin.effectivejava.ch05.item33.bounded_type_token;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

// 코드 33-5 asSubclass를 사용해 한정적 타입 토큰을 안전하게 형변환한다. (204쪽)
public class PrintAnnotation {

	static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
		Class<?> annotationType = null; // 비한정적 타입 토큰

		try {
			// Class.forName() 메서드는 비한정적 클래스 타입
			annotationType = Class.forName(annotationTypeName);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex);
		}

		/**
		 * getAnnotation은 한정적 클래스 타입
		 * 따라서 .asSubclass(Annotation.class) 부여해야 함
		 */
		return element.getAnnotation(annotationType.asSubclass(Annotation.class));
	}

	// 명시한 클래스의 명시한 애너테이션을 출력하는 테스트 프로그램
	public static void main(String[] args) throws Exception {
		System.out.println(getAnnotation(MyService.class, FindMe.class.getName()));
	}
}
