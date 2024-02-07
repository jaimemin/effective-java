package com.tistory.jaimemin.effectivejava.ch02.item02.hiearchicalbuilder;

import static com.tistory.jaimemin.effectivejava.ch02.item02.hiearchicalbuilder.NyPizza.Size.*;
import static com.tistory.jaimemin.effectivejava.ch02.item02.hiearchicalbuilder.Pizza.Topping.*;

public class PizzaTest {

	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(SMALL)
			.addTopping(SAUSAGE)
			.addTopping(ONION)
			.build();
		Calzone calzone = new Calzone.Builder()
			.addTopping(HAM)
			.sauceInside()
			.build();

		System.out.println(pizza);
		System.out.println(calzone);
	}
}
