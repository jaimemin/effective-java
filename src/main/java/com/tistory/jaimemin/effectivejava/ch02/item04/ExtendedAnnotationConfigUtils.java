package com.tistory.jaimemin.effectivejava.ch02.item04;

import org.springframework.context.annotation.AnnotationConfigUtils;

public class ExtendedAnnotationConfigUtils extends AnnotationConfigUtils {

	public static void main(String[] args) {
		ExtendedAnnotationConfigUtils configUtils = new ExtendedAnnotationConfigUtils();
		configUtils.registerAnnotationConfigProcessors(null);
	}
}
