package com.tistory.jaimemin.effectivejava.ch02.item12;

// PhoneNumber에 toString 메서드 추가 (75쪽)
public final class PhoneNumber {
	private final short areaCode, prefix, lineNum;

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
	// 외부에 공개할 수 있는 데이터만 보여줘야 함
	// 로그 정보도 탈취당할 수 있다는 가정하에 orderId 정도만 노출
	// 상세한 order 내용을 공개해서는 안되는 케이스도 있음
	@Override
	public String toString() {
		return String.format("%03d-%03d-%04d",
			areaCode, prefix, lineNum);
	}

	// 특정 포맷을 원할 경우 직접 정의하는게 바람직
	// 위처럼 우리가 사용하는 객체의 특성에 맞게끔 구현할 필요도 있음

	/**
	 * 정적 팩토리 메서드를 만들어주는 것도 권장
	 */
	public static PhoneNumber of(String phoneNumberString) {
		String[] split = phoneNumberString.split("-");
		PhoneNumber phoneNumber = new PhoneNumber(
			Short.parseShort(split[0]),
			Short.parseShort(split[1]),
			Short.parseShort(split[2]));

		return phoneNumber;
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

	public short getAreaCode() {
		return areaCode;
	}

	public short getPrefix() {
		return prefix;
	}

	public short getLineNum() {
		return lineNum;
	}

	/**
	 * Object에서 기본적으로 제공하는 toString의 경우
	 * 클래스 이름 뒤에 @ 16진수로 표현한 hashCode 값이 보여짐
	 * ex) com.tistory.jaimemin.effectivejava.item12.PhoneNumber@adbbd
	 *
	 * 별로 유용하지 않은 정보이기 때문에 toString은 꼭 구현하도록 하자
	 */

	public static void main(String[] args) {
		PhoneNumber phoneNumber = new PhoneNumber(707, 867, 5309);
		System.out.println(String.format("전화번호: %s", phoneNumber));

		// PhoneNumber phoneNumber = PhoneNumber.of("707-867-5309");
		// System.out.println(phoneNumber);
		// System.out.println(jenny.equals(phoneNumber));
		// System.out.println(jenny.hashCode() == phoneNumber.hashCode());
	}
}
