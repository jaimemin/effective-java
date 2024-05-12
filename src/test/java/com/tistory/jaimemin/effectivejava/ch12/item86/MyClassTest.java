package com.tistory.jaimemin.effectivejava.ch12.item86;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyClassTest {

	private static String DATA = "data";

	private String base64MyClass;

	// @BeforeEach
	void serializable() throws IOException {
		MyClass myClass = new MyClass(DATA);
		byte[] bytes;

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(myClass);

				bytes = baos.toByteArray();
			}
		}

		base64MyClass = Base64.getEncoder().encodeToString(bytes);
		System.out.println(base64MyClass);
	}

	@Test
	void deserializable() throws IOException, ClassNotFoundException {
		byte[] serializedMyClass = Base64.getDecoder().decode(base64MyClass);
		MyClass myClass;

		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMyClass)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				myClass = (MyClass)ois.readObject();
			}
		}

		assertThat(myClass.getData()).isEqualTo(DATA);
	}

	@Test
	void deserializableOld() throws IOException, ClassNotFoundException {
		byte[] serializedMyClass = Base64.getDecoder()
			.decode(
				"rO0ABXNyADZjb20udGlzdG9yeS5qYWltZW1pbi5lZmZlY3RpdmVqYXZhLmNoMTIuaXRlbTg2Lk15Q2xhc3McmXeQ8e4TEgIAAkwABGRhdGF0ABJMamF2YS9sYW5nL1N0cmluZztMAAduZXdEYXRhcQB+AAF4cHQABGRhdGFw");
		MyClass myClass;

		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMyClass)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				myClass = (MyClass)ois.readObject();
			}
		}

		assertThat(myClass.getData()).isEqualTo(DATA);
	}
}