package com.tistory.jaimemin.effectivejava.ch05.item26.object;

import java.util.ArrayList;
import java.util.List;

// 코드 26-4 런타임에 실패한다. - unsafeAdd 메서드가 로 타입(List)을 사용 (156-157쪽)
public class Raw {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		unsafeAdd(strings, Integer.valueOf(42));
		String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어준다.
	}

	/**
	 * 파라미터 타입이 굉장히 general 함
	 *
	 * List -> List<Object>로 변경하면 List<String>을 애초에 받을 수 없으므로 타입 안전성 제공
	 */
	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}
}

