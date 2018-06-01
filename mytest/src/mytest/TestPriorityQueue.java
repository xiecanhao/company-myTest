package mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TestPriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Integer> ints = new PriorityQueue<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		System.out.println(list);
		for (Integer num : list) {
			ints.offer(num);
			System.out.println(ints);
		}
		// System.out.println(ints);
		// ints.poll();
		// System.out.println(ints);
		while (!ints.isEmpty()) {
			ints.poll();
			System.out.println(ints);
		}
	}
}
