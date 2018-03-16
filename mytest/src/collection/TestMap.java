package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestMap {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}
		for (Integer i : map.keySet()) {
			System.out.print(i + ",");
		}
		System.out.println();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey() + ",");
		}
		System.out.println();
		int num = 16 - 1 & 10;
		System.out.println(num);
	}
}
