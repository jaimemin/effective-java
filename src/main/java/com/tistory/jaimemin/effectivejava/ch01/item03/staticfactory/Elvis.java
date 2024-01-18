package com.tistory.jaimemin.effectivejava.ch01.item03.staticfactory;

/**
 * 코드 3-2 정적 팩터리 방식의 싱글턴 (24쪽)
 *
 * 장점: 클라이언트 코드 변경 없이 싱글톤으로 반환할지 새로운 생성자로 반환할지 변경 가능
 * 단점은 field 방식과 동일 (해결책과 동일)
 */
public class Elvis implements Singer {
	private static final Elvis INSTANCE = new Elvis(); // field 와 다른 점은 이 부분이 private

	private Elvis() {
	}

	public static Elvis getInstance() {
		// return new  Elvis();
		return INSTANCE;
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	@Override
	public void sing() {
		System.out.println("my way~~~");
	}

	// 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
	public static void main(String[] args) {
		Elvis elvis = Elvis.getInstance();
		elvis.leaveTheBuilding();

		System.out.println(Elvis.getInstance());
		System.out.println(Elvis.getInstance());
	}

}
