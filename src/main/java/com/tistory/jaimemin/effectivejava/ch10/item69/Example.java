package com.tistory.jaimemin.effectivejava.ch10.item69;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example {

	private static int MAX = 10_000;

	public static void main(String[] args) {
		Range[] range = new Range[MAX];

		for (int i = 0; i < MAX; i++) {
			range[i] = new Range(i);
		}

		long start = System.currentTimeMillis();

		try {
			int i = 0;

			while (true) {
				range[i++].climb();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			log.error("" + e);
		}

		long end = System.currentTimeMillis();

		System.out.println(String.format("잘못된 최적화 실행시간: %d", end - start));

		start = System.currentTimeMillis();

		for (int i = 0; i < MAX; i++) {
			range[i].climb();
		}

		end = System.currentTimeMillis();
		System.out.println(String.format("반복문 실행시간: %d", end - start));

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
			System.out.print(i.next());

			if (i.hasNext()) {
				System.out.print(" ");
			}
		}

		System.out.println();

		try {
			Iterator<Integer> i = list.iterator();

			while (true) {
				System.out.print(i.next() + " ");
			}
		} catch (NoSuchElementException e) {
			log.error("" + e);
		}
	}

	static class Range {

		private int height;

		public Range(int height) {
			this.height = height;
		}

		public void climb() {
			// System.out.println("climb() 메서드 호출");
		}
	}
}
