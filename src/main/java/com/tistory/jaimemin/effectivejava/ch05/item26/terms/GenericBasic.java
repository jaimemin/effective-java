package com.tistory.jaimemin.effectivejava.ch05.item26.terms;

public class GenericBasic {

	public static void main(String[] args) {
		/**
		 * Generic 사용하기 전
		 * 컬렉션이 어떤 타입을 다루는지 명시하지 않음
		 * 지원하지 않는 타입을 추가하더라도 컴파일 타임에 알 수가 없고
		 * 런타임에 ClassCastException 발생
		 * 버그 원인 찾아내기 어려움
		 *
		 * 코드 작성할 때는 Object 타입으로 아무거나 넣을 수 있음
		 */
		//        List numbers = new ArrayList();
		//        numbers.add(10);
		//        numbers.add("jaimemin"); // 컴파일 에러 발생 안함
		//
		//        for (Object number: numbers) {
		//            System.out.println((Integer)number); // 형변환 필요
		//        }

		/**
		 * Generic 등장 이후
		 * Integer 타입만 넣을 수 있다고 명시했고
		 * 컴파일 타임에 Integer 타임 외 다른 타입 넣으려고 하면 컴파일 에러 발생
		 * fail-fast!!
		 *
		 */
		//        List<Integer> nuberms = new ArrayList<>();
		//        nuberms.add(10);
		//        nuberms.add("jaimemin");
		//
		//        for (Integer number: nuberms) {
		//            System.out.println(number); // 이미 지원하는 타입을 알고 있어 형변환 안해도 됨
		//        }
	}
}
