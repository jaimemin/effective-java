package com.tistory.jaimemin.effectivejava.ch07.item44;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class FunctionalInterfaceTest {

	@Test
	void UnaryOperatorTest() {
		UnaryOperator<String> unaryOperator = String::toLowerCase;

		assertThat(unaryOperator.apply("JAIMEMIN")).isEqualTo("jaimemin");
	}

	@Test
	void BinaryOperatorTest() {
		BinaryOperator<BigInteger> binaryOperator = BigInteger::add;

		assertThat(binaryOperator.apply(BigInteger.ZERO, BigInteger.ZERO)).isEqualTo(BigInteger.valueOf(0L));
	}

	@Test
	void PredicateTest() {
		Predicate<Collection> predicate = Collection::isEmpty;

		assertThat(predicate.test(new HashSet())).isTrue();
	}

	@Test
	void functionTest() {
		Function<int[], List<Integer>> function = arr ->
			IntStream.of(arr)
				.boxed()
				.collect(Collectors.toList());
		int[] array = {1, 2, 3, 4, 5};

		assertThat(function.apply(array).size()).isEqualTo(5);
	}

	@Test
	void SupplierTest() {
		Instant past = Instant.now().minusMillis(1);
		Supplier<Instant> supplier = Instant::now;

		assertThat(supplier.get().isAfter(past)).isTrue();
	}

	@Test
	void ConsumerTest() {
		OutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		Consumer consumer = System.out::print;
		consumer.accept("jaimemin");

		assertThat(output.toString()).isEqualTo("jaimemin");
	}
}
