package com.tistory.jaimemin.effectivejava.ch11.item79.reentrant_lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.tistory.jaimemin.effectivejava.ch11.item79.ForwardingSet;

public class ObservableSet<E> extends ForwardingSet<E> {

	public ObservableSet(Set<E> set) {
		super(set);
	}

	private final List<SetObserver<E>> observers = new ArrayList<>();

	private final Lock lock = new ReentrantLock();

	public void addObserver(SetObserver<E> observer) {
		lock.lock();

		try {
			observers.add(observer);
		} finally {
			lock.unlock();
		}
	}

	public boolean removeObserver(SetObserver<E> observer) {
		lock.lock();

		try {
			return observers.remove(observer);
		} finally {
			lock.unlock();
		}
	}

	private void notifyElementAdded(E element) {
		lock.lock();

		try {
			for (SetObserver<E> observer : observers)
				observer.added(this, element);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean add(E element) {
		boolean added = super.add(element);

		if (added) {
			notifyElementAdded(element);
		}

		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;

		for (E element : c) {
			result |= add(element);  // Calls notifyElementAdded
		}

		return result;
	}
}

