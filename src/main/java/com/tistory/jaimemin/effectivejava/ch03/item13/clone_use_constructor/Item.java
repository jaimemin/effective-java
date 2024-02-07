package com.tistory.jaimemin.effectivejava.ch03.item13.clone_use_constructor;

public class Item implements Cloneable {

	private String name;

	/**
	 * super.clone()을 사용하지 않고 생성자를 통해 복사할 경우
	 * 상위 타입을 하위 타입으로 형변환을 못하기 때문에
	 * 이렇게 구현하면 하위 클래스의 clone()이 깨질 수 있다. p78
	 *
	 */
	@Override
	public Item clone() {
		try {
			Item result = (Item)super.clone(); // 제대로 구현하는 방법

			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
		// Item item = new Item();
		// item.name = this.name;
		//
		// return item;
	}
}
