package com.tistory.jaimemin.effectivejava.ch02.item09.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * try-with-resources 의 장점: 예외를 잡아 먹지 않는다
 * target 폴더 내 byte-code 확인하자 (addSuppressed)
 * -> br.close() 여러번 호출하며 확실히 닫히도록
 * 의외로 finally block을 사용하지 않고 중첩된 try-catch를 사용
 */
public class TopLine {

	// 코드 9-1 try-finally - 더 이상 자원을 회수하는 최선의 방책이 아니다! (47쪽)
	static String firstLineOfFile(String path) throws IOException {
		try (BufferedReader br = new BadBufferedReader(new FileReader(path))) {
			return br.readLine();
		}

		/**
		 * 해당 코드는 가장 마지막 예외만 보임
		 * 반면 try-with-resources는 모든 예외가 다 보임
		 * 사실 가장 중요한 예외는 최초 발생한 예외
		 *
		 * 가독성도 좋지만 모든 예외를 알 수 있다는 장점도 있음
		 */
		// BufferedReader br = new BadBufferedReader(new FileReader(path));
		//
		// try {
		// 	return br.readLine();
		// } finally {
		// 	br.close();
		// }
	}

	public static void main(String[] args) throws IOException {
		System.out.println(firstLineOfFile("pom.xml"));
	}
}