package stream;

import java.util.ArrayList;
import java.util.List;

public class Stream1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("asdfadfa");
		list.add("123afasd");
		list.add("adfa");
		list.add("a13a2s1d3fa");
		list.add("465a6sdfa");
		list.add("as31");
		list.add("aa123");
		list.stream().limit(4).forEach(s -> System.out.println(s));
		long count = list.parallelStream().filter(s -> s.length() > 7).count();
		System.out.println(count);
	}
}
