package com.tistory.jaimemin.effectivejava.ch10.item75;

public class Example {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int idx = 4;

		if (idx >= arr.length) {
			throw new IndexOutOfBoundsException(0, arr.length, idx);
		}

		int num = arr[idx];
	}
}
