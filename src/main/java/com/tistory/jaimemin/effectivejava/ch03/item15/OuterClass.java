package com.tistory.jaimemin.effectivejava.ch03.item15;

import java.util.Arrays;

public class OuterClass {

	private static class PrivateStaticClass {

	}

	private class InnerClass {

	}

	public static void main(String[] args) {
		Arrays.stream(OuterClass.InnerClass.class.getDeclaredFields()).forEach(System.out::println);
		Arrays.stream(OuterClass.PrivateStaticClass.class.getDeclaredFields()).forEach(System.out::println);
	}
}
