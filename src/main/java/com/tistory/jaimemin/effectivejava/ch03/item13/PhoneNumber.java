package com.tistory.jaimemin.effectivejava.ch03.item13;

import java.util.HashMap;
import java.util.Map;

/**
 * 불변 객체
 */
// PhoneNumber에 clone 메서드 추가 (79쪽)
public final class PhoneNumber implements Cloneable {
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "지역코드");
		this.prefix = rangeCheck(prefix, 999, "프리픽스");
		this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
		System.out.println("constructor is called");
	}

	/**
	 * Cloneable 사용 지양
	 * Copy 생성자
	 * 장점
	 * 명확하고 
	 * 애매모호한 규약에서 벗어나고
	 * final 가변 필드 사용 가능
	 * 파라미터로 상위 타입을 받아 하위 타입으로 변환 가능 (clone은 불가능) -> HashSetExample 참고
	 */
	public PhoneNumber(PhoneNumber phoneNumber) {
		this(phoneNumber.areaCode, phoneNumber.prefix, phoneNumber.lineNum);
	}

	private static short rangeCheck(int val, int max, String arg) {
		if (val < 0 || val > max) {
			throw new IllegalArgumentException(arg + ": " + val);
		}

		return (short)val;
	}

	/**
	 * 불변 객체에서 대표적으로 clone()을 구현하는 방법
	 * 어떤 클래스를 상속받아서 오버라이딩할 때 접근지시자는 항상 상위 클래스의 접근 지시자와 같거나 넓은 지시자
	 * protected로 할 경우 하위 클래스에서만 쓸 수 있는 메서드이기 때문에 쓸모가 없음
	 * -> 해당 클래스를 복사하려는 클라이언트 코드는 대부분 PhoneNumber의 하위 클래스가 아닐 확률이 높기 때문에
	 * -> clone()이 인터페이스에 없는 것이 이상함
	 *
	 * Object가 아닌 더 구체적인 타입으로 반환하게끔 오버라이딩하여 클라이언트 코드에서 타입 캐스팅 안해도 됨
	 */
	// 코드 13-1 가변 상태를 참조하지 않는 클래스용 clone 메서드 (79쪽)
	@Override
	public PhoneNumber clone() {
		try {
			return (PhoneNumber)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();  // 일어날 수 없는 일이다.
		}
	}

	/**
	 * 원래 clone의 모습
	 */
	// @Override
	// protected Object clone() throws CloneNotSupportedException {
	// 	return super.clone();
	// }
	public static void main(String[] args) {
		PhoneNumber pn = new PhoneNumber(707, 867, 5309);
		Map<PhoneNumber, String> m = new HashMap<>();
		m.put(pn, "jaimemin");
		PhoneNumber clone = pn.clone();
		System.out.println(m.get(clone));

		System.out.println(clone != pn); // 반드시 true
		System.out.println(clone.getClass() == pn.getClass()); // 반드시 true
		System.out.println(clone.equals(pn)); // true가 아닐 수도 있다.
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

}