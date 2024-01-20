package com.tistory.jaimemin.effectivejava.ch01.item07.stack;

import java.util.Arrays;

// 코드 7-1 메모리 누수가 일어나는 위치는 어디인가? (36쪽)
public class Stack {
	private Object[] elements; // 메모리를 직접 관리하는 경우에는 메모리 누수 조심해야함
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	/**
	 * 꺼내서 주기만 보면 계속해서 Object 배열에 element가 쌓이기만 함
	 * 언젠가는 꽉 차서 메모리 누수가 발생 OOM
	 */
	//    public Object pop() {
	//        if (size == 0)
	//            throw new EmptyStackException();
	//        return elements[--size];
	//    }

	/**
	 * 원소를 위한 공간을 적어도 하나 이상 확보한다.
	 * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
	 */
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	// 코드 7-2 제대로 구현한 pop 메서드 (37쪽)

	/**
	 * 꺼내서 주기만 보면 계속해서 Object 배열에 element가 쌓이기만 함
	 * 언젠가는 꽉 차서 메모리 누수가 발생 OOM
	 * <p>
	 * 따라서 null 로 다 쓴 참조 해제 필요
	 */
	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		Object result = elements[--size];
		elements[size] = null; // 다 쓴 객체 참조 해제 (명시적)

		return result;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();

		for (String arg : args) {
			stack.push(arg);
		}

		while (true) {
			System.err.println(stack.pop());
		}
	}
}