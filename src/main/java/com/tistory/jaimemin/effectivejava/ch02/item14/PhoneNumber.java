package com.tistory.jaimemin.effectivejava.ch02.item14;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

// PhoneNumber를 비교할 수 있게 만든다. (91-92쪽)
public final class PhoneNumber implements Cloneable {

	private final short areaCode, prefix, lineNum;

	public short getAreaCode() {
		return areaCode;
	}

	public short getPrefix() {
		return prefix;
	}

	public short getLineNum() {
		return lineNum;
	}

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "지역코드");
		this.prefix = rangeCheck(prefix, 999, "프리픽스");
		this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
	}

	private static short rangeCheck(int val, int max, String arg) {
		if (val < 0 || val > max) {
			throw new IllegalArgumentException(arg + ": " + val);
		}

		return (short)val;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof PhoneNumber)) {
			return false;
		}

		PhoneNumber pn = (PhoneNumber)o;

		return pn.lineNum == lineNum
			&& pn.prefix == prefix
			&& pn.areaCode == areaCode;
	}

	@Override
	public int hashCode() {
		int result = Short.hashCode(areaCode);
		result = 31 * result + Short.hashCode(prefix);
		result = 31 * result + Short.hashCode(lineNum);

		return result;
	}

	/**
	 * 이 전화번호의 문자열 표현을 반환한다.
	 * 이 문자열은 "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다.
	 * XXX는 지역 코드, YYY는 프리픽스, ZZZZ는 가입자 번호다.
	 * 각각의 대문자는 10진수 숫자 하나를 나타낸다.
	 *
	 * 전화번호의 각 부분의 값이 너무 작아서 자릿수를 채울 수 없다면,
	 * 앞에서부터 0으로 채워나간다. 예컨대 가입자 번호가 123이라면
	 * 전화번호의 마지막 네 문자는 "0123"이 된다.
	 */
	@Override
	public String toString() {
		return String.format("%03d-%03d-%04d",
			areaCode, prefix, lineNum);
	}

	/**
	 * equals와 달리 Object가 아닌 T를 넘겨 받아 타입을 신경쓰지 않아도 됨
	 * 매우 큰 차이
	 *
	 * Primitive Type의 경우 해당 타입의 박싱 비교자를 쓰는 것을 권장
	 */
	// 코드 14-2 기본 타입 필드가 여럿일 때의 비교자 (91쪽)
	// @Override
	// public int compareTo(PhoneNumber pn) {
	// 	int result = Short.compare(areaCode, pn.areaCode);
	//
	// 	if (result == 0) {
	// 		result = Short.compare(prefix, pn.prefix);
	//
	// 		if (result == 0) {
	// 			result = Short.compare(lineNum, pn.lineNum);
	// 		}
	// 	}
	//
	// 	return result;
	// }

	/**
	 * Java 8+부터 제공하는 Comparator
	 *
	 * Comparator라는 인터페이스가 제공하는 static 메서드를 통해 Comparator 인스턴스를 생성 가능
	 * ex) reverseOrder, nullsFirst, nullsLast, comparing, comparingInt, ...
	 *
	 * comparing 매개변수에 keyComparator 있으면 내가 정의한 순서대로 compareTo
	 * 없으면 해당 제너릭 타입의 natural order로 비교 (대신 해당 클래스가 Comparable 구현 안했으면 캐스팅 에러
	 *
	 * Comparator를 static method로 생략해도 되지만 Comparator를 붙이는 것을 선호
	 * 팩토리 메서드를 통해 Comparator를 생성했다면 thenComparingInt로 체이닝 가능
	 */
	// 코드 14-3 비교자 생성 메서드를 활용한 비교자 (92쪽)
	private static final Comparator<PhoneNumber> COMPARATOR =
		Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
			.thenComparingInt(pn -> pn.getPrefix())
			.thenComparingInt(pn -> pn.lineNum);

	private static PhoneNumber randomPhoneNumber() {
		Random rnd = ThreadLocalRandom.current();

		return new PhoneNumber((short)rnd.nextInt(1000),
			(short)rnd.nextInt(1000),
			(short)rnd.nextInt(10000));
	}

	public static void main(String[] args) {
		Set<PhoneNumber> s = new TreeSet<>(COMPARATOR);

		for (int i = 0; i < 10; i++) {
			s.add(randomPhoneNumber());
		}

		System.out.println(s);
	}

}
