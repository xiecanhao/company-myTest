package mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main5 {
	public static void main(String[] args) {
		int a = 8;
		int b = a - 1 >> 1;
		System.out.println(b);
		Map<String, Object> map = new HashMap<>();
		map.putAll(null);
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10 } };
		// assert false;//断言，调试的时候使用，需要运行的时候添加 -ea参数才有效，为false的时候抛AssertionError
		System.out.println(b);
		// aaa();
		// for (int i = 0; i < 100; i++)
		// System.out.println((int) (Math.random() * 3));
		// testString();
		// System.out.println(System.getProperty("java.class.path"));
		// System.out.println(
		// "----------------------------------------------------");
		// System.out.println(System.getProperty("java.ext.dirs"));
		// System.out.println(
		// "----------------------------------------------------");
		// String s = System.getProperty("sun.boot.class.path");
		// for (String temp : s.split(";")) {
		// System.out.println(temp);
		// }13213132
		// Hashtable<K, V>
		// HashMap<K, V>
	}

	private static void aaa() {
		String str = getString("abc");
		System.out.println(str);
		List<Object> list = new ArrayList<>();
		list.add("a13d");
		list.add(123);
		Set<String> set = new HashSet<>();
	}

	private static String getString(String string) {
		String temp = "";
		try {
			temp = string;
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			temp = "123";
		}
		return temp;
	}

	private static void testString() {
		Map<String, String> map = new IdentityHashMap<String, String>();
		map.put(new String("xxx"), "first");
		map.put(new String("xxx"), "second");
		for (String s : map.keySet()) {
			System.out.println(map.get(s));
		}
	}
}
