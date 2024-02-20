package com.tistory.jaimemin.effectivejava.ch05.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

// T 생산자 매개변수에 와일드카드 타입 적용 (184쪽)
public class Chooser<T> {

	private final List<T> choiceList;

	private final Random rnd = new Random();

	// 코드 31-5 T 생산자 매개변수에 와일드카드 타입 적용 (184쪽)

	/**
	 * 먼가를 받아오는 쪽이므로 producer
	 */
	public Chooser(Collection<? extends T> choices) {
		choiceList = new ArrayList<>(choices);
	}

	public T choose() {
		return choiceList.get(rnd.nextInt(choiceList.size()));
	}

	public static void main(String[] args) {
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
		Chooser<Number> chooser = new Chooser<>(intList); // Number를 Integer로 쓰는 것은 불가능하지만 Integer는 Number로 사용 가능

		for (int i = 0; i < 10; i++) {
			Number choice = chooser.choose();
			System.out.println(choice);
		}
	}
}
