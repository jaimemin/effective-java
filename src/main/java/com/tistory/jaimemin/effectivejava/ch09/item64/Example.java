package com.tistory.jaimemin.effectivejava.ch09.item64;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Example {

	public static void main(String[] args) {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Apple");
		linkedHashSet.add("Banana");
		linkedHashSet.add("Orange");

		System.out.println("LinkedHashSet 순회:");
		Iterator<String> linkedIterator = linkedHashSet.iterator();

		while (linkedIterator.hasNext()) {
			System.out.println(linkedIterator.next());
		}

		// HashSet으로 변경하는 경우
		HashSet<String> hashSet = new HashSet<>(linkedHashSet);

		System.out.println("\nHashSet 순회:");
		Iterator<String> hashIterator = hashSet.iterator();

		while (hashIterator.hasNext()) {
			System.out.println(hashIterator.next());
		}

		try (OutputStream outputStream = new FileOutputStream("output.txt")) {
			// 로직
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

