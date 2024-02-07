package com.tistory.jaimemin.effectivejava.ch02.item02.freeze;

import java.util.ArrayList;
import java.util.List;

/**
 * Java에서는 너무나 헷갈리는 기능
 * 중간에 객체를 얼리고 그 뒤로 불변으로 만든다?
 * -> 사실상 변경이 가능한 가변 객체인데 중간에 불변으로 만든다?
 * -> 기준은, 시점은?
 * 코딩하기 어려운 조건
 * javascript에서도 잘 사용되지 않을 기능으로 생각
 *
 * mutable vs immutable 공부하기
 */
public class Person {

	private String name;

	private int birthYear;

	private List<String> kids;

	private boolean frozen;

	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
		this.kids = new ArrayList<>();
	}

	public void setName(String name) {
		checkIfObjectIsFrozen();
		this.name = name;
	}

	private void checkIfObjectIsFrozen() {
		if (this.frozen) {
			throw new IllegalStateException("Object is frozen");
		}
	}

}
