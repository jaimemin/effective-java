package com.tistory.jaimemin.effectivejava.ch08.item52;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {

	public static void main(String[] args) {
		// Thread의 생성자 호출
		new Thread(System.out::println).start();

		// ExecutorService의 submit 메서드 호출
		ExecutorService exec = Executors.newCachedThreadPool();
		// exec.submit(System.out::println);

		// 예시로 사용할 char 배열
		char[] charArray = {'H', 'e', 'l', 'l', 'o'};

		// valueOf(char[]) 메서드 사용
		String stringValueOfCharArray = String.valueOf(charArray);
		System.out.println("Result of valueOf(char[]): " + stringValueOfCharArray);

		// valueOf(Object) 메서드 사용 (char 배열을 Object로 감싸서 전달)
		Object objectCharArray = charArray;
		System.out.println("Result of valueOf(Object): " + objectCharArray);
	}
}
