package com.tistory.jaimemin.effectivejava.ch03.item13.copy_constructor;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * clone 규약이 너무 많음
 * 현실적으로 clone 사용하지 않고 생성자를 통해 copy
 * 혹은 복사 전용 팩토리 메서드
 */
public class HashSetExample {

	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("jaimemin");
		hashSet.add("gudetama");
		System.out.println("HashSet: " + hashSet);

		Set<String> treeSet = new TreeSet<>(hashSet);

		System.out.println("TreeSet: " + treeSet);
	}
}
