package com.tistory.jaimemin.effectivejava.ch11.item83;

public class RacySingleCheck {

	private int sharedValue = 0; // 다른 기본 타입을 사용하는 필드

	// 필드 값 업데이트 메서드
	public void updateValue(int newValue) {
		sharedValue = newValue; // 필드 값을 업데이트함
	}

	// 필드 값 읽기 메서드
	public int getValue() {
		return sharedValue; // 필드 값을 반환함
	}

	public static void main(String[] args) {
		RacySingleCheck example = new RacySingleCheck();

		// 쓰레드 생성
		Thread thread1 = new Thread(() -> {
			example.updateValue(1);
		});

		Thread thread2 = new Thread(() -> {
			example.updateValue(2);
		});

		// 쓰레드 실행
		thread1.start();
		thread2.start();

		// 메인 쓰레드는 쓰레드들이 작업을 마칠 때까지 기다림
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("필드 값: " + example.getValue());
	}
}

