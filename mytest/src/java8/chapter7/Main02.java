package java8.chapter7;

import java.util.ArrayList;
import java.util.List;

public class Main02 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		;
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.stream().filter(n -> n > 5)
				.forEach(s -> System.out.print(s + ","));
		System.out.println();
		list.parallelStream().filter(s -> s > 5)
				.forEach(s -> System.out.print(s + ","));
		;
	}
}
