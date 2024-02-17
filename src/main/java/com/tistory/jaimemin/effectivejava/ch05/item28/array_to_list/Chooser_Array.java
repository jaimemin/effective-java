package com.tistory.jaimemin.effectivejava.ch05.item28.array_to_list;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 코드 28-6 배열 기반 Chooser
public class Chooser_Array {
	private final Object[] choiceList; // 어떤 값들이 들어오는지 모르는 상태

	public Chooser_Array(Collection choices) {
		choiceList = choices.toArray();
	}

	public Object choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceList[rnd.nextInt(choiceList.length)];
	}

	public static void main(String[] args) {
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
		// 넘겨 받는 컬렉션에 Number 타입만 있다는 것을 보장 할 수 있는가?
		Chooser_Array chooser = new Chooser_Array(intList);

		for (int i = 0; i < 10; i++) {
			Number choice = (Number)chooser.choose(); // 타입 캐스팅하는 과정에서 ClassCastException 발생 가능
			System.out.println(choice);
		}
	}
}
