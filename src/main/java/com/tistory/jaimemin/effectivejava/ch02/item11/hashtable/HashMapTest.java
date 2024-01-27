package com.tistory.jaimemin.effectivejava.ch02.item11.hashtable;

import java.util.HashMap;
import java.util.Map;

import com.tistory.jaimemin.effectivejava.ch02.item11.hashcode.PhoneNumber;

public class HashMapTest {

	public static void main(String[] args) {
		Map<PhoneNumber, String> map = new HashMap<>();

		PhoneNumber number1 = new PhoneNumber(123, 456, 7890);
		PhoneNumber number2 = new PhoneNumber(456, 789, 1111);

		// 같은 인스턴스인데 다른 hashCode
		// 다른 인스턴스인데 같은 hashCode를 쓴다면?
		System.out.println(number1.equals(number2));
		System.out.println(number1.hashCode());
		System.out.println(number2.hashCode());

		map.put(number1, "jaimemin");
		map.put(number2, "gudetama");

		/**
		 * equals가 같은데 hashcode가 매번 다를 경우
		 *
		 * get을 할 때 hashmap에 넣는 과정과 꺼내는 과정을 이해해야 함
		 * key에 대한 hashcode를 먼저 가져와서 hash에 해당하는 bucket에 넣고 뺀다
		 * hashcode가 매번 다를 경우 hashmap에는 이런 hash가 없는데?하면서 null이 나오는 것
		 */
		String s = map.get(number2);
		// String s = map.get(new PhoneNumber(123, 456, 7890)); // null
		System.out.println(s);
	}
}
