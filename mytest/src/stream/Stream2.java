package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Stream2 {
	public static void main(String[] args) throws IOException {
		Stream<Integer> integerStream = Stream.of(10, 20, 30, 40);
		String[] cityArr = { "beijing", "shanghai", "chengdu" };
		Stream<String> cityStream = Stream.of(cityArr);
		Stream<String> nameStream = Arrays.asList("daniel", "peter", "kevin")
				.stream();
		Stream<String> cityStream2 = Arrays.stream(cityArr, 0, 1);
		Stream<String> emptyStream = Stream.empty();
		// printStream(cityStream, nameStream, cityStream2, emptyStream);
		// System.out.println("end printStream");

		Stream<String> echos = Stream.generate(() -> "echo");
		Stream<Integer> integer = Stream.iterate(0, num -> num + 1);

		Stream<String> lines = Files.lines(Paths.get("test.txt"));
		lines.forEach(s -> System.out.println(s));

		String content = "AXDBDGXC";
		Stream<String> contentStream = Pattern.compile("[ABC]{1,3}")
				.splitAsStream(content);
		contentStream.forEach(s -> System.out.println(s));
	}

	private static void printStream(Stream<String>... arr) {
		for (Stream<String> stream : arr) {
			stream.forEach(s -> {
				System.out.println(s);
			});
			System.out.println();
		}

	}
}
