package com.tistory.jaimemin.effectivejava.ch01.item03.field;

import java.io.Serializable;

/**
 * 코드 3-1 public static final 필드 방식의 싱글턴 (23쪽)
 *
 * 장점: 간결하고 가독성 좋음
 * 생성자가 private 이니까 인스턴스를 생성하지 못하도록 막았구나,
 * static final 로 선언해두면 java document 로 만들 때 별도 필드로 보여줌
 *
 * 단점: 싱글톤을 사용하는 클라이언트 코드를 테스트하기 어려워진다
 * interface 없이 정의한 코드는 더더욱 테스트하기 어려움 (Concert 에서 IElvis 대신 Elvis)
 */
public class Elvis implements IElvis, Serializable {

	/**
	 * 싱글톤 오브젝트
	 */
	public static final Elvis INSTANCE = new Elvis();

	private static boolean created;

	private Elvis() {
		// reflection 통해 새로운 인스턴스 생성하는 경우 방지
		if (created) {
			throw new UnsupportedOperationException("can't be created by constructor.");
		}

		created = true;
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	public void sing() {
		System.out.println("I'll have a blue~ Christmas without you~");
	}

	/**
	 * 역직렬화할 때 사용되는 메서드
	 * 재정의할 경우 역직렬화할 때마다 새로운 인스턴스 생성되는 케이스 방지 가능
	 * @Override는 안 먹음
	 */
	private Object readResolve() {
		return INSTANCE;
	}

	// 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilding();
	}

}
