package com.tistory.jaimemin.effectivejava.ch01.item01;

import java.util.Arrays;

public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    private OrderStatus orderStatus;

    public Order() {}

    public Order(Product product, boolean prime) {
        this.product = product;
        this.prime = prime;
    }

    /**
     * 시그니처가 생성자의 매개변수 타입까지 봄
     * 우회하고자 생성자 매개변수 순서를 변경한다면 우회할 수 있겠지만...
     * 생성자는 이름을 표현할 수 없고 클래스명과 동일
     */
    public Order(boolean urgent, Product product) {
        this.product = product;
        this.urgent = urgent;
    }

    /**
     * 정적 팩토리 메서드를 사용할 때는
     * 메서드명을 통해 표현을 더 잘해줄 수 있다는 장점
     */
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;

        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;

        return order;
    }

    public static void main(String[] args) {
        Arrays.stream(OrderStatus.values()).forEach(System.out::println); // Enum 질문 1
    }
}
