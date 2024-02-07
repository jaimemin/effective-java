package com.tistory.jaimemin.effectivejava.ch02.item08.finalizer;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class App {

	/**
	 * 코드 참고 https://www.baeldung.com/java-finalize
	 */
	public static void main(String[] args) throws
		InterruptedException,
		ClassNotFoundException,
		NoSuchFieldException,
		IllegalAccessException {
		int i = 0;
		while (true) {
			i++;
			new FinalizerIsBad(); // 가비지 컬렉션해야하는 객체가 무한정 생성

			/**
			 * 큐를 처리하는 우선수위가 객체를 생성하는 우선순위보다 낮기 때문에 큐에 잔뜩 쌓일 수 있음
			 * finalize() 메서드 안에서 다른 객체를 참조하는 식으로 작성하면 오히려 정리할 객체가 더 늘어나 추천 안함
			 */
			if ((i % 1_000_000) == 0) {
				Class<?> finalizerClass = Class.forName("java.lang.ref.Finalizer");
				Field queueStaticField = finalizerClass.getDeclaredField("queue");
				queueStaticField.setAccessible(true);
				ReferenceQueue<Object> referenceQueue = (ReferenceQueue)queueStaticField.get(null);

				Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength");
				queueLengthField.setAccessible(true);
				long queueLength = (long)queueLengthField.get(referenceQueue);
				System.out.format("There are %d references in the queue%n", queueLength);
			}
		}
	}
}
