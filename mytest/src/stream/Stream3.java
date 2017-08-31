package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream3 {
	public static void main(String[] args) {
		List<String> langList = Arrays.asList("java", "python", "swift",
				"html");
		/* Stream<String> filterStream = */langList.stream()
				.filter(lang -> lang.equalsIgnoreCase("JAVA"))
				.forEach(lang -> System.out.println(lang));

		Stream<String> mapStream = langList.stream().map(String::toUpperCase);
		mapStream.forEach(s -> {
			System.out.println(s);
		});
	}
}
