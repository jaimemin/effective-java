package com.tistory.jaimemin.effectivejava.ch04.item24.memberclass;

import java.util.AbstractSet;
import java.util.Iterator;

public class MySet<E> extends AbstractSet<E> {

	/**
	 * Iterator 타입을 MyIterator로 가져감
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	@Override
	public int size() {
		return 0;
	}

	/**
	 * Iterator 구현체를 내부적으로 정의하고
	 */
	private class MyIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public E next() {
			return null;
		}
	}

}
