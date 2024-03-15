package com.tistory.jaimemin.effectivejava.ch09.item57;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example {

	private static int exception() throws IOException {
		throw new IOException();
	}

	public static void main(String[] args) {
		try {
			int a = exception();
		} catch (IOException e) {
			log.error("" + e);
		}

		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		Iterator<Integer> i = list.iterator();

		while (i.hasNext()) {
			// 비즈니스 로직
		}

		Iterator<Integer> i2 = list2.iterator();

		// 실수로 i2가 아닌 i를 쓰는데도 불구하고 컴파일 에러 발생 안함
		while (i.hasNext()) {
			// 비즈니스 로직
		}

		for (Iterator<Integer> i3 = list.iterator(); i3.hasNext(); ) {
			// 비즈니스 로직
		}

		// 컴파일 에러 발생
		// for (Iterator<Integer> i4 = list.iterator(); i3.hasNext(); ) {
		//
		// }
	}
}
