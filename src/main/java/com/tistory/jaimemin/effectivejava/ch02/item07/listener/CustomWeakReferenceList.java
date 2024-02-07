package com.tistory.jaimemin.effectivejava.ch02.item07.listener;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomWeakReferenceList<T> {

	private List<WeakReference<T>> list = new ArrayList<>();

	private ReferenceQueue<T> referenceQueue = new ReferenceQueue<>();

	public CustomWeakReferenceList() {
		// 백그라운드 쓰레드를 통해 ReferenceQueue 를 폴링하여 빈 Weak Reference 를 정리
		new Thread(() -> {
			while (true) {
				try {
					referenceQueue.remove();
					cleanUp();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();

					break;
				}
			}
		}).start();
	}

	public void add(T obj) {
		list.add(new WeakReference<>(obj, referenceQueue));
	}

	public List<WeakReference<T>> getList() {
		return list;
	}

	public void cleanUp() {
		Iterator<WeakReference<T>> iterator = list.iterator();

		while (iterator.hasNext()) {
			WeakReference<T> weakRef = iterator.next();

			if (weakRef.get() == null) {
				iterator.remove();
			}
		}
	}
}
