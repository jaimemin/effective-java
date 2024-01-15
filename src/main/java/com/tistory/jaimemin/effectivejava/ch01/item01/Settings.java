package com.tistory.jaimemin.effectivejava.ch01.item01;

/**
 * 자바의 생성자는 매번 호출될 때마다 새로운 인스턴스 생성
 * 이 클래스의 인스터는 #getInstance()를 통해 사용한다.
 * @see #getInstance()
 */
public class Settings {

    private boolean useAutoSteering;

    private boolean useABS;

    private Difficulty difficulty;

    /**
     * 상속을 못 받는다는 단점
     * mvn javadoc:javadoc 명령어로 문서 생성했을 때 인스턴스 생성 방법이 명확하게 보이지 않는 단점 (생성자 목록에 노출이 안됨)
     * -> 자주 쓰이는 메서드명을 사용하자 (of, valueOf, newInstance, ...)
     */
    private Settings() {}
    
    private static final Settings SETTINGS = new Settings();

    /**
     * 객체의 생성 로직을 정적 팩토리 메서드를 통해 통제
     * ex) Boolean.valueOf
     *
     * 플라이웨이트 패턴(디자인 패턴 중 하나)는 자주 사용하는 값을 미리 캐싱해서 넣어두고 꺼내오는 방식
     */
    public static Settings getInstance() {
        return SETTINGS; // 오로지 정적 팩토리 메서드를 통해서만 인스턴스를 가져갈 수 있음
    }

    public static void main(String[] args) {
        // hash code 값을 통해 매번 새로운 인스턴스를 생성하는 것을 확인 가능
        System.out.println(new Settings());
        System.out.println(new Settings());
        System.out.println(new Settings());
    }
}
