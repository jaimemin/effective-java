package com.tistory.jaimemin.effectivejava.ch03.item20.objectmethod;

/**
 * 묵시적으로 모든 클래스는 Object를 상속하고 있음
 *
 * toString, equals, hashCode를 default 메서드로 제공할 수 있을 경우
 * interface에서 정의한 메서드를 사용할지 Object에서 정의한 메서드를 사용할지 헷갈리기 시작
 * 인터페이스에서 굳이 위 메서드들을 정의할 필요도 없음 (토이 프로젝트에서나 어울리는 기능)
 *
 * https://mail.openjdk.org/pipermail/lambda-dev/2013-March/008435.html 참
 */
public class MyClass extends Object implements MyInterface {
}
