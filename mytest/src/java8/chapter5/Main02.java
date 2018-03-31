package java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main02 {
	public static void main(String[] args) {
		String[] arr = { "hello", "world" };
		// map和flatMap的区别
		Stream<String> stream = Arrays.stream(arr);
		List<Stream<String>> list1 = stream.map(word -> word.split(""))
				.map(Arrays::stream).distinct().collect(Collectors.toList());
		list1.stream().forEach((s) -> System.out.println(s));

		List<String> list2 = Arrays.stream(arr).map(w -> w.split(""))
				.flatMap(Arrays::stream).distinct()
				.sorted((o1, o2) -> o1.hashCode() - o2.hashCode())
				.collect(Collectors.toList());
		list2.stream().forEach(s -> System.out.println(s));
	}
}
