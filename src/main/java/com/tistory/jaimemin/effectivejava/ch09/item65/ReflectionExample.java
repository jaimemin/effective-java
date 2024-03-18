package com.tistory.jaimemin.effectivejava.ch09.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectionExample {

	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			// 클래스 이름을 이용하여 Class 객체 가져오기
			Class<?> clazz = Class.forName("com.tistory.jaimemin.effectivejava.ch09.item65.MyClass");
			// 생성자 정보 가져오기
			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
			// NoArgsConstructor 즉, 디폴트 생성자를 사용하여 객체 생성
			Object instance = constructors[0].newInstance();
			// AllArgsConstructor를 상용하여 객체 생성
			Object instance2 = constructors[1].newInstance("gudetama", 29);
			// 메서드 정보 가져오기
			Method[] methods = clazz.getDeclaredMethods();

			// 메서드 호출 예제
			for (Method method : methods) {
				if (method.getName().equals("displayInfo")) {
					// 매개변수 타입에 맞게 인자 전달
					System.out.print("디폴트 생성자로 생성한 인스턴스: ");
					method.invoke(instance);
					System.out.print("AllArgsConstructor로 생성한 인스턴스: ");
					method.invoke(instance2);
				}
			}

			// 필드 정보 가져오기
			Field[] fields = clazz.getDeclaredFields();

			System.out.println("디폴트로 생성한 생성자 setter를 Relection으로 접근하여 값 설정");
			// 필드 값 설정 및 가져오기 예제
			for (Field field : fields) {
				if (field.getName().equals("name")) {
					// 필드에 접근 가능하도록 설정
					field.setAccessible(true);
					field.set(instance, "jaimemin");
				} else if (field.getName().equals("age")) {
					// 필드에 접근 가능하도록 설정
					field.setAccessible(true);
					field.set(instance, 29);
				}
			}

			// displayInfo() 메서드 호출하여 변경된 정보 출력
			for (Method method : methods) {
				if (method.getName().equals("displayInfo")) {
					// 매개변수 타입에 맞게 인자 전달
					System.out.print("디폴트 생성자로 생성한 인스턴스: ");
					method.invoke(instance);
				}
			}
			long end = System.currentTimeMillis();
			System.out.println(String.format("실행시간: %d", (end - start)));
		} catch (Exception e) {
			log.error("" + e);
		}
	}
}