package com.tistory.jaimemin.effectivejava.ch06.item39.markerannotation;

// Program to process marker annotations (Page 182)

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
	public static void main(String[] args) throws ClassNotFoundException {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);
		
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;

				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " 실패: " + exc);
				} catch (Exception e) {
					System.out.println("잘못 사용한 @Test: " + m);
				}
			}
		}

		System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
	}
}
