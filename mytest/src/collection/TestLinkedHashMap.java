package collection;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {
	public static void main(String[] args) {
		LinkedHashMap<Integer, Integer> temp = new LinkedHashMap<>();
		temp.put(3, 2);
		temp.put(4, 1);
		temp.put(7, 0);
		temp.put(6, -1);
		for (Integer i : temp.keySet()) {
			System.out.println(i + ":" + temp.get(i));
		}
		for (int i : temp.values()) {
			System.out.println(i);
		}
	}
}
