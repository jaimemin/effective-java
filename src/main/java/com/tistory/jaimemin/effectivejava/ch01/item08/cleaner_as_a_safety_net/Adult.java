package com.tistory.jaimemin.effectivejava.ch01.item08.cleaner_as_a_safety_net;

// cleaner 안전망을 갖춘 자원을 제대로 활용하는 클라이언트 (45쪽)
public class Adult {
	public static void main(String[] args) {
		try (Room myRoom = new Room(7)) {
			System.out.println("안녕~");
		}
	}
}
