package com.tistory.jaimemin.effectivejava.ch11.item78;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Example {

	private static volatile int nextSerialNumber = 0;

	public static synchronized int generateSerialNumber() {
		return nextSerialNumber++;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> num2cnt = new ConcurrentHashMap<>();

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1e6; i++) {
				int num = generateSerialNumber();

				if (num2cnt.get(num) == null) {
					num2cnt.put(num, 1);
				} else {
					num2cnt.put(num, num2cnt.get(num) + 1);
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1e6; i++) {
				int num = generateSerialNumber();

				if (num2cnt.get(num) == null) {
					num2cnt.put(num, 1);
				} else {
					num2cnt.put(num, num2cnt.get(num) + 1);
				}
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		for (Map.Entry<Integer, Integer> entry : num2cnt.entrySet()) {
			if (entry.getValue() >= 2) {
				System.out.println(String.format("%d가 %d번 반환됨.\n", entry.getKey(), entry.getValue()));
			}
		}
	}
}
