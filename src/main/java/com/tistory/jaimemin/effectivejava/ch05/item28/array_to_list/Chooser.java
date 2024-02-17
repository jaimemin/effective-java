package com.tistory.jaimemin.effectivejava.ch05.item28.array_to_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 코드 28-6 리스트 기반 Chooser - 타입 안전성 확보! (168쪽)

/**
 * 타입을 선언할 경우 범용적으로 사용하면서 타입 안전성 확보
 * 성능이 엄청 민감한 상황이 아니라면 배열보다는 리스트 권장
 */
public class Chooser<T> {
	private final List<T> choiceList;

	public Chooser(Collection<T> choices) {
		choiceList = new ArrayList<>(choices);
	}

	public T choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceList.get(rnd.nextInt(choiceList.size()));
	}

	public static void main(String[] args) {
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

		Chooser<Integer> chooser = new Chooser<>(intList);

		for (int i = 0; i < 10; i++) {
			Number choice = chooser.choose();
			System.out.println(choice);
		}
	}
}
