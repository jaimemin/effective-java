package com.tistory.jaimemin.effectivejava.ch09.item61;

import java.lang.reflect.Method;

public class Example2 {

	public static void main(String[] args) throws Exception {
		MyClass obj = new MyClass();
		String methodName = "printNumber";
		Class[] parameterTypes = {Integer.class}; // 여기서는 박싱된 기본 타입 Integer를 사용
		// 리플렉션을 통해 메서드 가져오기
		Method method = MyClass.class.getMethod(methodName, parameterTypes);
		method.invoke(obj, 10); // 정수 값 10을 메서드에 전달 (박싱된 Integer 객체로 전달됨)
	}
}

class MyClass {

	public void printNumber(Integer num) {
		System.out.println(num);
	}
}

