package com.tistory.jaimemin.effectivejava.ch01.item03.staticfactory;

/**
 * 코드 3-2 제네릭 싱글톤 팩토리 (24쪽)
 *
 * 장점: 제너릭한 타입을 쓸 때 인스턴스는 동일하지만 각각이 원하는 타입으로 형변환해서 쓸 수 있음 (29 ~ 30 라인 참고)
 */
public class MetaElvis<T> {

	private static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

	private MetaElvis() {
	}

	/**
	 * 다른 scope 이기 때문에 별도 제너릭 선언 필요
	 */
	@SuppressWarnings("unchecked")
	public static <E> MetaElvis<E> getInstance() {
		return (MetaElvis<E>)INSTANCE; // 원하는 타입으로 변환해주는 역할
	}

	public void say(T t) {
		System.out.println(t);
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	public static void main(String[] args) {
		MetaElvis<String> elvis1 = MetaElvis.getInstance();
		MetaElvis<Integer> elvis2 = MetaElvis.getInstance();
		// equals 로는 true, == 비교는 할 수 없음 (타입이 다르기 때문에)
		System.out.println(elvis1);
		System.out.println(elvis2);
		elvis1.say("hello");
		elvis2.say(100);
	}

}
