package com.tistory.jaimemin.effectivejava.ch01.item08.autoclosable;

public class App {

	/**
	 * cleaner는 phantomReference를 내부적으로 사용
	 * native peer(native한 라이브러리 C, C++, OS에 특화되어 있는 코드) 자원을 해제하는데 사용 가능
	 * cleaner를 사용하는 주된 이유는 안전망
	 */
	public static void main(String[] args) {
		try (AutoClosableIsGood good = new AutoClosableIsGood("")) {
			// 자원 반납 처리가 됨.

		}
	}
}
