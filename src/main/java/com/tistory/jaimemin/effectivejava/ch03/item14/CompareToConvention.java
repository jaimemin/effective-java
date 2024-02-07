package com.tistory.jaimemin.effectivejava.ch03.item14;

import java.math.BigDecimal;

public class CompareToConvention {

	/**
	 * Object.equals에 더해서 순서까지 비교
	 * 따라서, 반사성, 대치성, 추이성, 일관성 다 지켜야함
	 */
	public static void main(String[] args) {
		BigDecimal n1 = BigDecimal.valueOf(23134134);
		BigDecimal n2 = BigDecimal.valueOf(11231230);
		BigDecimal n3 = BigDecimal.valueOf(53534552);
		BigDecimal n4 = BigDecimal.valueOf(11231230);

		// p88, 반사성
		System.out.println("반사성 확인");
		System.out.println(String.format("n1 == n1 ? %s", isSame(n1.compareTo(n1))));

		// p88, 대칭성
		System.out.println("대치성 확인");
		System.out.println(String.format("n1 > n2 result ? %s", (n1.compareTo(n2)) > 0));
		System.out.println(String.format("n2 < n1 result ? %s", (n2.compareTo(n1)) < 0));

		// p89, 추이성
		System.out.println("추이성 확인");
		System.out.println(String.format("n3 > n1 ? %s", n3.compareTo(n1) > 0));
		System.out.println(String.format("n1 > n2 ? %s", n1.compareTo(n2) > 0));
		System.out.println(String.format("n3 > n2 ? %s", n3.compareTo(n2) > 0));

		// p89, 일관성
		System.out.println("일관성 확인");
		System.out.println(String.format("n4 == n2 ? %s", isSame(n4.compareTo(n2))));
		System.out.println(String.format("n2 > n1 ? %s", (n2.compareTo(n1)) > 0));
		System.out.println(String.format("n4 > n1 ? %s", (n4.compareTo(n1)) > 0));

		// p89, compareTo가 0이라면 equals는 true여야 한다. (아닐 수도 있고..)
		BigDecimal oneZero = new BigDecimal("1.0");
		BigDecimal oneZeroZero = new BigDecimal("1.00");
		// 순서가 있는 컬렉션에서 사용, ex) Tree, TreeMap
		System.out.println(
			String.format("1.0 vs 1.00 same in comparable ? %s", isSame(oneZero.compareTo(oneZeroZero))));
		// 순서가 없는 콜렉션, equals를 사용할 때는 scale 정보까지 비교하기 때문에 같다고 안 나옴
		System.out.println(String.format("1.0 vs 1.00 different in equals ? %s", !oneZero.equals(oneZeroZero)));
	}

	public static boolean isSame(int result) {
		return result == 0;
	}

}
