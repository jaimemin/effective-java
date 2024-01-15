package com.tistory.jaimemin.effectivejava.ch01.item01;

import java.util.*;

public class InterfaceQuiz {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < 10; i++)
        {
            numbers.add(random.nextInt() % 100);
        }

        Comparator<Integer> desc = (o1, o2) -> o2 - o1;
        Collections.sort(numbers, desc);

        System.out.println(numbers);

        numbers.sort(desc.reversed());

        System.out.println(numbers);
    }
}
