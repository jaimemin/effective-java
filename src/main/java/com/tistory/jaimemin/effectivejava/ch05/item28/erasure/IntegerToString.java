package com.tistory.jaimemin.effectivejava.ch05.item28.erasure;

import java.util.ArrayList;
import java.util.List;

/**
 * 컴파일하면 List의 경우 타입 정보가 소멸됨
 * Item 26 참조
 * 제너릭 타입을 보면 캐스팅함
 * 자바 하위 호환성 보장을 위해
 *
 * 반면 배열의 경우 실체화가 됨 (런타임에도 자신이 담기로 한 원소의 타입을 인지하고 확인)
 */
public class IntegerToString {

	public static void main(String[] args) {
		/**
		 * 공변
		 * Object는 최상위 계층이므로 String과 Object는 호환이 됨
		 * 따라서 Object[] 배열에 String을 담을 수 있음
		 * Object[] 배열로 선언했지만 실제 인스턴스는 String 배열
		 * 컴파일은 되지만 문제는 있음
		 * 배열은 공변이기 때문에 String 배열에 Integer를 넣을 때 런타임에 잡아낼 수 없음
		 * ArrayStoreException 발생
		 * 성능적으로 인덱스에 바로 접근할 수 있기 때문에 효율이 좋지만... 안전성 떨어짐
		 */
		Object[] anything = new String[10];
		anything[0] = 1;

		/**
		 * 불공변
		 * 제너릭은 상위 타입, 하위 타입 의미 없어짐
		 * Object와 String은 상하관계가 존재하지만 List<String> 인스턴스를 List<Object> 타입으로 선언할 수 없음
		 * 컴파일 시점에 잡아내기 때문에 안전성 보장
		 */
		List<String> names = new ArrayList<>();
		//        List<Object> objects = names;

		/**
		 * 제네릭과 배열을 같이 사용할 수 있다면...
		 * 47번째 라인까지 문제 없이 돌아가지만
		 * 48번째 라인에서 String으로 캐스팅 하려고 하는데 0번째 인덱스는 Integer 배열이기 때문에 ClassCastException
		 */
		//        List<String>[] stringLists = new ArrayList<String>[1];
		//        List<Integer> intList = List.of(42);
		//        Object[] objects = stringLists;
		//        objects[0] = intList;
		//        String s = stringLists[0].get(0);
		//        System.out.println(s);
	}
}
