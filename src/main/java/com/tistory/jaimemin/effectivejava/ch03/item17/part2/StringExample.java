package com.tistory.jaimemin.effectivejava.ch03.item17.part2;

public class StringExample {

	public static void main(String[] args) {
		String name = "jaimemin";

		StringBuilder nameBuilder = new StringBuilder(name);
		nameBuilder.append("gudetama");
	}
}
