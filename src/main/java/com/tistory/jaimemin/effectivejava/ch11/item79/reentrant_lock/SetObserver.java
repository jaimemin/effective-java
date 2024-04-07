package com.tistory.jaimemin.effectivejava.ch11.item79.reentrant_lock;

public interface SetObserver<E> {

	// Invoked when an element is added to the observable set
	void added(ObservableSet<E> set, E element);
}