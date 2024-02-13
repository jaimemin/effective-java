package com.tistory.jaimemin.effectivejava.ch05.item27.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RetentionPolicy.SOURCE
 * 컴파일러만 애노테이션을 참조해서 먼가 컴파일할 때 경고를 만들거나
 * 에러를 만들거나
 * 컴파일할 때 AnnotationProcessor를 적용해서 코드를 생성하거나 그러고 싶다
 *
 * RententionPolicy.CLASS, RUNTIME
 * 런타임 중에 특정 어노테이션이 붙어있는 모든 클래스를 찾아가지고 빈으로 등록하는 등 특정 작업 수행하고 싶다
 * BYTECODE로 처리 - ClASS
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyAnnotation {

}
