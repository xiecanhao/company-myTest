package mytest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayList {
	public static void main(String[] args) {
		long a = Long.MAX_VALUE;
		double b = a;
		System.out.println(a);
		System.out.println(b);
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Integer> it = list.iterator();
		System.out.println(list);
		while (it.hasNext()) {
			Integer next = it.next();
			if (next == 1) {
				it.remove();
			}
		}
		System.out.println(list);
	}
}
