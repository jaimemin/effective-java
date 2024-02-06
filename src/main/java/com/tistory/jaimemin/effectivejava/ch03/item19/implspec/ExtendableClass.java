package com.tistory.jaimemin.effectivejava.ch03.item19.implspec;

/**
 * Example class for java documentation for extendable class
 *
 * 해당 클래스를 상속받아 재정의하는 메서드가 내부 구현을 알아야하기 때문에 어차피 캡슐화가 깨짐
 * InstrumentedSet의 addAll의 내부 동작을 모르는 상태에서 구현했을 때 count가 3이 아닌 6이 됨
 * -> 어차피 캡슐화를 깨고 내부 구현에 대한 내용을 문서화할 필요가 잇음 @implSpec
 *
 * @implSpec은 java8+부터 쓰인 tag (annotation 아님)
 *
 * javadoc -d target/apidoc src/main/java/com/tistory/jaimemin/effectivejava/ch03/item19/implspec/* -tag "implSpec:a:Implementation Requirements:"
 *
 * 어떤 메서드를 오버라이딩할지는 직접 서브 클래스를 생성해보는 방법 뿐 (최소 3개, 본인 뿐만 아니라 동료들도 만들어보는 방향으로)
 */
public class ExtendableClass {

	/**
	 * This method can be overridden to print any message.
	 *
	 * @implSpec
	 * Please use System.out.println().
	 */
	protected void doSomething() {
		System.out.println("hello");
	}
}
