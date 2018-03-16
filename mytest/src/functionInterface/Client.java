package functionInterface;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		// MyInterface my = () -> {
		// System.out.println("get method");
		// };
		// my.get();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.stream().limit(4).forEach(s -> {
			int i = s + 1;
			System.out.println(i);
		});
	}
}
