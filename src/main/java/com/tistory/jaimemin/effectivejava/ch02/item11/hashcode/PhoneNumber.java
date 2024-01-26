package com.tistory.jaimemin.effectivejava.ch02.item11.hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Lombok이 제공하는 EqualsAndHashCode를 사용하는 것을 추천
 * -> lombok으로 작성하는 코드들은 굳이 테스트할 필요 없음
 * -> 반면 equals, hashcode를 우리가 구현하면 테스트 필요
 *
 * 굳이 equals, hashcode를 사용하기 위해 guava 라이브러리 쓰는 것은 잘 모르겠음
 */
// equals를 재정의하면 hashCode로 재정의해야 함을 보여준다. (70-71쪽)
public final class PhoneNumber {
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix = rangeCheck(prefix, 999, "prefix");
		this.lineNum = rangeCheck(lineNum, 9999, "line num");
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

	/**
	 * 두 객체에 대한 equals가 다르더라도 hashcode가 다를 경우
	 * hash collision
	 * hash bucket 오브젝트를 linked list로 만들어줌
	 * O(1) -> O(N)으로 시간복잡도가 아쉬워짐
	 */
	//    @Override
	//    public int hashCode() {
	//        return 42;
	//    }

	// hashCode 없이는 제대로 동작하지 않는다. 다음 셋 중 하나를 활성화하자.

	/**
	 * primitive type의 경우 정의된 hashCode 구하면 됨
	 * Array -> Arrays.hashCode()
	 * Point -> Point.hashCode()
	 *
	 * 31인 이유: 짝수가 아닌 홀수, hash 충돌이 가장 적은 숫자가 31
	 */
	// 코드 11-2 전형적인 hashCode 메서드 (70쪽)
	//    @Override public int hashCode() {
	//        int result = Short.hashCode(areaCode); // 1
	//        result = 800000 * result + Short.hashCode(prefix); // 2
	//        result = 800000 * result + Short.hashCode(lineNum); // 3
	//        return result;
	//    }

	/**
	 * Intellij가 만들어주는 hashCode도 내부적으로 보면 위 hashCode와 비슷하게 구현
	 * Arrays.hashCode(values) -> 31
	 *
	 * equals에 쓰이는 필드는 hashCode에 모두 반영해야 함
	 */
	// 코드 11-3 한 줄짜리 hashCode 메서드 - 성능이 살짝 아쉽다. (71쪽)
	//    @Override public int hashCode() {
	//        return Objects.hash(lineNum, prefix, areaCode);
	//    }

	/**
	 * 불변 객체의 경우 hashCode를 필드로 정의
	 * 해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려해야 한다. (71쪽)
	 *
	 * 다수의 쓰레드가 동시에 hashCode()를 들어오면 엇갈리면서 계산해서 다른 값이 나올 수 있음
	 * 쓰레드의 안전성 고려하여 volatile가 synchronized 키워드 사용하자
	 *
	 * volatile은 캐시가 아닌 메인 메모리에서 참조 (가장 최근에 업데이트된 값이 반환)
	 */
	private volatile int hashCode; // 자동으로 0으로 초기화된다.

	@Override
	public int hashCode() {
		// 공유 필드가 이미 세팅되었다면 바로 반환
		if (this.hashCode != 0) {
			return hashCode;
		}

		// lock을 걸어 동기화 (한 쓰레드만 들어갈 수 있도록)
		// double checking lock
		synchronized (this) {
			int result = hashCode;

			if (result == 0) {
				result = Short.hashCode(areaCode);
				result = 31 * result + Short.hashCode(prefix);
				result = 31 * result + Short.hashCode(lineNum);
				this.hashCode = result;
			}

			return result;
		}
	}
	// hashtable은 thread-safe, hashmap은 thread-safe하지 않음

	public static void main(String[] args) {
		Map<PhoneNumber, String> m = new HashMap<>();
		m.put(new PhoneNumber(707, 867, 5309), "제니");
		System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
	}
}
