package com.tistory.jaimemin.effectivejava.ch05.item27.unchecked;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set names = new HashSet(); // 아이템 26 - 로 타입은 쓰지 말자

		Set<String> strings = new HashSet<>(); // suppressed warning 없어짐
	}
}
