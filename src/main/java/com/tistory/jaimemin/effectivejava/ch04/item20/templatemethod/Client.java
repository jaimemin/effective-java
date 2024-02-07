package com.tistory.jaimemin.effectivejava.ch04.item20.templatemethod;

public class Client {

	public static void main(String[] args) {
		FileProcessor fileProcessor = new Plus("number.txt");
		System.out.println(fileProcessor.process());
		System.out.println(fileProcessor.process(Integer::sum));
	}
}
