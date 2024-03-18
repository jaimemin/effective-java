package com.tistory.jaimemin.effectivejava.ch09.item65;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Set;

// Reflective instantiaion demo (Page 283)
public class ReflectiveInstantiation {
	// Reflective instantiation with interface access
	public static void main(String[] args) {
		// Translate the class name into a Class object
		Class<? extends Set<String>> cl = null;

		try {
			cl = (Class<? extends Set<String>>)  // Unchecked cast!
				Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			fatalError("Class not found.");
		}

		// Get the constructor
		Constructor<? extends Set<String>> cons = null;

		try {
			cons = cl.getDeclaredConstructor();
		} catch (NoSuchMethodException e) {
			fatalError("No parameterless constructor");
		}

		// Instantiate the set
		Set<String> s = null;
		try {
			s = cons.newInstance();
		} catch (ReflectiveOperationException e) {
			fatalError("Error during instantiation: " + e.getMessage());
		} catch (ClassCastException e) {
			fatalError("Class doesn't implement Set");
		}

		// Exercise the set
		s.addAll(Arrays.asList(args).subList(1, args.length));
		System.out.println(s);
	}

	private static void fatalError(String msg) {
		System.err.println(msg);
		System.exit(1);
	}
}
