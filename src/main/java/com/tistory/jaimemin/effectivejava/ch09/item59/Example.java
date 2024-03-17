package com.tistory.jaimemin.effectivejava.ch09.item59;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Example {

	static Random rnd = new Random();

	static int random(int n) {
		return Math.abs(rnd.nextInt()) % n;
	}

	public static List<Map.Entry<Integer, Integer>> sortByValue(Map<Integer, Integer> map) {
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

		return list;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> num2cnt = new HashMap<>();

		for (int i = 0; i < 1024; i++) {
			int num = random(1 << 10);

			num2cnt.put(num, num2cnt.get(num) == null ? 1 : num2cnt.get(num) + 1);
		}

		List<Map.Entry<Integer, Integer>> sortedEntries = sortByValue(num2cnt);

		for (Map.Entry<Integer, Integer> entry : sortedEntries) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
