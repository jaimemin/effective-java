package com.tistory.jaimemin.effectivejava.ch02.item03.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializationExample {

	private void serialize(Book book) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("book.obj"))) {
			out.writeObject(book);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Book deserialize() {
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("book.obj"))) {
			return (Book)in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		//        Book book = new Book("12345", "이팩티브 자바 완벽 공략", "백기선",
		//                LocalDate.of(2022, 3, 21));
		//        book.setNumberOfSold(200);

		SerializationExample example = new SerializationExample();
		//        example.serialize(book);
		Book deserializedBook = example.deserialize();

		//        System.out.println(book);
		System.out.println(deserializedBook);
	}
}
