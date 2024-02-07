package com.tistory.jaimemin.effectivejava.ch02.item08.outerclass;

import java.lang.reflect.Field;

public class OuterClass {

	private void hi() {

	}

	// outerclass 에 종속적인 클래스
	class InnerClass {

		/**
		 * 정적이 아닌 중첩 클래스를 그걸 감싸고 있는 외부 클래스 레퍼런스가 생기기 때문에
		 * 클리너 등록할 때 반드시 스태틱으로 (굳이 Runnable을 안에다 두는 경우) -> 중첩 레퍼런스 방지하기 위해 (중첩이면 자원 정리 안됨)
		 */
		public void hello() {
			OuterClass.this.hi();
		}

	}

	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		InnerClass innerClass = outerClass.new InnerClass();

		System.out.println(innerClass);

		outerClass.printFiled();
	}

	private void printFiled() {
		Field[] declaredFields = InnerClass.class.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println("field type:" + field.getType());
			System.out.println("field name:" + field.getName());
		}
	}
}
