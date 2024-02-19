package com.tistory.jaimemin.effectivejava.ch05.item29.technqiue1;

import java.util.Arrays;
import java.util.List;

import com.tistory.jaimemin.effectivejava.ch05.item29.EmptyStackException;

// E[]를 이용한 제네릭 스택 (170-174쪽)
public class Stack<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	// 코드 29-3 배열을 사용한 코드를 제네릭으로 만드는 방법 1 (172쪽)

	/**
	 * 제네릭 배열은 컴파일러가 막기 때문에 이런 식으로 구현
	 *
	 * 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
	 * 따라서 타입 안전성을 보장하지만,
	 * 이 배열의 런타임 타입은 E[]가 아닌 Object[]다!
	 *
	 * elements 배열 필드가 private이기 때문에 외부에 노출될 일이 없고
	 * push 메서드에서 E 타입만 받기 때문에 SuppressedWarnings 부여해도 괜찮음
	 * 힙 오염이 발생할 수 있는 단점 존재
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

	// 힙 오염을 발생시키는 메서드 추가
	public void heapPollutionExample() {
		Object[] objects = elements;
		objects[0] = new Integer(42); // 다양한 타입의 객체를 배열에 추가
	}

	// 코드 29-5 제네릭 Stack을 사용하는 맛보기 프로그램 (174쪽)
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		for (String arg : List.of("a", "b", "c")) {
			stack.push(arg);
		}

		stack.heapPollutionExample();

		while (!stack.isEmpty()) {
			System.out.println(stack.pop().toUpperCase());
		}
	}
}
