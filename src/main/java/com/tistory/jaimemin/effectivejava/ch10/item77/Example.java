package com.tistory.jaimemin.effectivejava.ch10.item77;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Example {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {

		}

		// Future<Integer> f = exec.submit(planarMap::chromaticNumber);
		// int numColors = 4; // 기본값. 어떤 지도라도 이 값이면 충분하다
		//
		// try {
		// 	numColors = f.get(1L, TimeUnit.SECONDS);
		// } catch (TimeoutException | ExecutionException | InterruptedException ignored) {
		// 	// 기본값을 사용한다(색상 수를 최소화하면 좋지만, 필수는 아니다)
		// }
	}
}
