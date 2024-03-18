package com.tistory.jaimemin.effectivejava.ch09.item65;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyClass {

	private String name;

	private int age;

	public void displayInfo() {
		System.out.println("이름: " + name + ", 나이: " + age);
	}

}

