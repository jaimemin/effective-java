package com.tistory.jaimemin.effectivejava.ch04.item15.member;

import java.util.Arrays;

/**
 * 구현체
 * 구현은 내부 패키지 안에서만 알면 되는거지
 * member package 밖에서는 DefaultMemberService인지 XXXMemberService인지 알 필요 없음
 * item은 MemberService라는 인터페이스만 가지고 개발하길 바람
 * 그렇다면 item은 어떤 MemberService 구현체를 가져다 쓰는 것이냐?
 * -> item은 알 필요 없음
 * -> 어떤거든지 이 member라는 모듈 혹은 컴포넌트에서 설정되어있는 Member Service를 가져다 쓰면 될 것 같다
 *
 * item에서 구체적인 클래스는 IOC 컨테이너 통해서 제공받는 형식으로 사용한다면 구체적인 구현체를 알 필요없음
 * ServiceLoader 또한 인터페이스만 알아도 됨
 */
class DefaultMemberService implements MemberService {

	private String name;

	/**
	 * 이 클래스가 DefaultMemberService 밖으로 나갈 필요 없음
	 * DefaultMemberService에서만 쓰이기 때문에
	 *
	 * 왜 private static class일까?
	 * -> inner class이지만 남이나 마찬가지
	 * 외부와 아무런 참조가 없음
	 *
	 * 원래 별개 클래스로 선언하려고 했기 때문에 private static이 어울림
	 * 두 클래스 간의 관계가 간단해지는 장점도 있음
	 */
	private static class PrivateStaticClass {

	}

	/**
	 * inner private class는 inner private class를 감싸고 있는 외부 인스턴스를 참조
	 * 외부 인스턴스를 참조하는 필드가 자동으로 생김
	 */
	private class PrivateClass {

	}

	/**
	 * 내부 클래스에서 감싸고 있는 외부 클래스 멤버 변수를 참조 가능
	 */
	public static void main(String[] args) {
		Arrays.stream(PrivateClass.class.getDeclaredFields()).forEach(System.out::println);
	}

}
