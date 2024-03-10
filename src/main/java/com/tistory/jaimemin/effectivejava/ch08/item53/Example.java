package com.tistory.jaimemin.effectivejava.ch08.item53;

public class Example {

	private int number;

	// 자바 5 버전 이전
	public int sum(int num) {
		return number + num;
	}

	public int sum(int num1, int num2) {
		return number + num1 + num2;
	}

	public int sum(int num1, int num2, int num3) {
		return number + num1 + num2 + num3;
	}

	// 자바 5 버전 이후
	public int sum(int... nums) {
		int total = number;

		for (int num : nums) {
			total += num;
		}

		return total;
	}

	// public int sum(int... nums, int... nums2) {
	//
	// }

	public void func() {
	}

	public void func(int a1) {
	}

	public void func(int a1, int a2) {
	}

	public void func(int a1, int a2, int a3) {
	}

	public void func(int a1, int a2, int a3, int... rest) {
	}
}
