package com.tistory.jaimemin.effectivejava.ch01.item01;

import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static void main(String[] args) {
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloServiceOptional = loader.findFirst();

        /**
         * 특정 구현체에 의존적이지 않은 코드
         * 특정 구현체를 import 하지 않아도 됨
         * 어떤 구현체가 올지 모르지만 구현체가 따르는 인터페이스를 구현하면 되는 유연함 제공
         * ex) JDBCDriver (MySQL, PostgreSQL, MS-SQL, Oracle, ... 모두 지원해야하는 Driver)
         * -> 아쉽게도 JDBCDriver 는 ServiceLoader 등장 전에 구현되어 ServiceLoader 를 사용하지는 않음
         */
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello());
        });
    }
}
