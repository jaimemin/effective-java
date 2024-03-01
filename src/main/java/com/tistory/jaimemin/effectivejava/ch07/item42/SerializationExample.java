package com.tistory.jaimemin.effectivejava.ch07.item42;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;

class SerializationExample {
	// private 정적 중첩 클래스로 Comparator 구현
	private static class MyComparator implements Comparator<String>, Serializable {
		@Override
		public int compare(String str1, String str2) {
			return str1.compareTo(str2);
		}
	}

	public static void main(String[] args) {
		// Comparator 객체 생성
		Comparator<String> comparator = new MyComparator();

		// 직렬화 및 역직렬화
		try {
			// 직렬화하여 바이트 배열로 변환
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(comparator);
			objectOutputStream.close();
			byte[] serializedData = byteArrayOutputStream.toByteArray();

			// 바이트 배열로부터 역직렬화
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			Comparator<String> deserializedComparator = (Comparator<String>)objectInputStream.readObject();
			objectInputStream.close();

			// 사용 예시
			int result = deserializedComparator.compare("apple", "orange");
			System.out.println("Comparison result: " + result);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

