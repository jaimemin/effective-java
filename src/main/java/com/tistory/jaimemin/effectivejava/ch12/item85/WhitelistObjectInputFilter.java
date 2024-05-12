package com.tistory.jaimemin.effectivejava.ch12.item85;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WhitelistObjectInputFilter implements ObjectInputFilter {

	private static Set<String> allowedClasses;

	public WhitelistObjectInputFilter(String... classNames) {
		allowedClasses = new HashSet<>(Arrays.asList(classNames));
	}

	@Override
	public Status checkInput(FilterInfo filterInfo) {
		// Check if the class being deserialized is allowed
		String className = filterInfo.serialClass().getName();

		if (allowedClasses.contains(className)) {
			return Status.ALLOWED;
		} else {
			return Status.REJECTED;
		}
	}

	public static void main(String[] args) {
		ObjectInputFilter filter = new WhitelistObjectInputFilter((String[])allowedClasses.toArray());
		// Set the custom filter globally
		System.setProperty("jdk.serialFilter", filter.getClass().getName());

		byte[] serializedData = new byte[1024]; //

		try (ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
			 ObjectInputStream ois = new ObjectInputStream(bis)) {
			Object obj = ois.readObject();

			System.out.println("역직렬화된 객체: " + obj);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
