package com.tistory.jaimemin.effectivejava.ch02.item13.exception;

/**
 * UncheckedException은 개발자 입장에서 작성하기 쉬움
 * CheckedException의 경우 던지거나 잡거나를 반드시 이행해야하지만
 * UncheckedException은 편리함
 *
 * 하지만 "편리함"이 UncheckedException을 사용하는 기준이 되어서는 안됨
 *
 * CheckedException을 사용하는 이유는 이 자체가 API이기 때문
 * -> 클라이언트에게 해당 메서드를 사용할 때 이런 예외가 발생할 수 있다와 대응이 필요하다고 정보를 알려줌
 * -> 사용하는 입장에서 명시적으로 에러가 나는 이유를 알 수 있음
 *
 * Clone 메서드에서 발생할 수 있는 CloneNotSupportedException의 경우 클라이언트가 복구할 수 있는 방법이 없기 때문에
 * UncheckedException이었어야 한다고 생각
 */
public class MyException extends Exception {
}