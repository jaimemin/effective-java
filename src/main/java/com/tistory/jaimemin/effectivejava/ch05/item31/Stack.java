package com.tistory.jaimemin.effectivejava.ch05.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

// 와일드카드 타입을 이용해 대량 작업을 수행하는 메서드를 포함한 제네릭 스택 (181-183쪽)

/**
 * E: 오로지 한 타입을 지칭
 * 그 타입의 상속구조를 따지지 않음 (불공변)
 * ex) Object 배열로 선언하면 Object만 넣을 수 있음 (Integer 못 넣음)
 */
public class Stack<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	// 코드 29-3 배열을 사용한 코드를 제네릭으로 만드는 방법 1 (172쪽)

	/**
	 * 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
	 * 따라서 타입 안전성을 보장하지만,
	 * 이 배열의 런타임 타입은 E[]가 아닌 Object[]다!
	 */
	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		E result = elements[--size];
		elements[size] = null; // 다 쓴 참조 해제

		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	// 코드 31-1 와일드카드 타입을 사용하지 않은 pushAll 메서드 - 결함이 있다! (181쪽)
	// public void pushAll(Iterable<E> src) {
	// 	for (E e : src) {
	// 		push(e);
	// 	}
	// }

	// 코드 31-2 E 생산자(producer) 매개변수에 와일드카드 타입 적용 (182쪽)

	/**
	 * Number의 하위 타입
	 * 받아서 넣는 것을 생산자라고 지칭하고 extends 키워드를 사용
	 * 상위 한정
	 */
	public void pushAll(Iterable<? extends E> src) {
		for (E e : src) {
			push(e);
		}
	}

	// 코드 31-3 와일드카드 타입을 사용하지 않은 popAll 메서드 - 결함이 있다! (183쪽)
	// public void popAll(Collection<E> dst) {
	// 	while (!isEmpty()) {
	// 		dst.add(pop());
	// 	}
	// }

	// 코드 31-4 E 소비자(consumer) 매개변수에 와일드카드 타입 적용 (183쪽)

	/**
	 * 꺼낼 떄는 그 타입보다 더 높은 타입을 꺼낼 수 있음
	 * 하위 한정
	 */
	public void popAll(Collection<? super E> dst) {
		while (!isEmpty()) {
			dst.add(pop());
		}
	}

	// 제네릭 Stack을 사용하는 맛보기 프로그램
	public static void main(String[] args) {
		Stack<Number> numberStack = new Stack<>();
		Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
		numberStack.pushAll(integers);

		Iterable<Double> doubles = Arrays.asList(3.1, 1.0, 4.0, 1.0, 5.0, 9.0);
		numberStack.pushAll(doubles);

		Collection<Object> objects = new ArrayList<>();
		numberStack.popAll(objects);

		System.out.println(objects);
	}
}
