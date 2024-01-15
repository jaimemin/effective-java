package com.tistory.jaimemin.effectivejava.ch01.item01;

public interface HelloService {

    String hello();

    /**
     * 생성자를 사용할 때는 딱 KoreanHelloService, EnglishHelloService 하나만 반환 가능
     * 정적 팩터리 메서드 사용 시 리턴하는 반환 타입에 호환 가능한 다른 인스턴스를 반환 가능하다는 장점
     * 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환 가능
     * 구체적인 타입을 클라이언트로부터 숨길 수 있음 (인터페이스)
     * 정적 팩토리 메서드를 생성하는 시점에 굳이 구현체가 없어도 됨
     */
    static HelloService of(String lang) {
        if ("ko".equals(lang)) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }

    // 정적 메서드
    static String hi() {
        return "hi";
    }

    // 기본 메서드
    default String bye() {
        return "bye";
    }
}
