package java8.chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {
	static int ii = 2;

	public static void main(String[] args) {
		Predicate<String> p = String::isEmpty;
		Consumer<String> c = (s) -> System.out.println(s);
		Function<String, Boolean> f = (s) -> s.length() > 0;
		Supplier<String> sup = () -> new String("123");
		Optional<String> o = Optional.of("123");

		System.out.println(Predicate.isEqual(""));
		System.out.println(p.equals(null));
		BinaryOperator.maxBy((o1, o2) -> o1.hashCode() - o2.hashCode());
		UnaryOperator<Object> ff = UnaryOperator.identity();
		UnaryOperator<Integer> u = (Integer a) -> a + 45;
		int i = 1;
		ii = 1;
		Runnable r = () -> System.out.println(ii);
		String s = "123";
		ToIntFunction<String> tf = Integer::parseInt;
		System.out.println(tf.applyAsInt(s));
		// Comparator<String> cs = null;
		// List<String> list = null;
		// list.sort(cs);
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> newList = numList.stream().map(n -> n * n)
				.collect(Collectors.toList());
		System.out.println(newList);
	}

}
