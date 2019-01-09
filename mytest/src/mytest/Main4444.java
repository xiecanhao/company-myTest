package mytest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main4444 {
	public static void main(String[] args) {
		long max = Long.MAX_VALUE;
		double d = (double) max;
		BigDecimal bd = new BigDecimal(
				99999999999999999999999999999999.999999999999999999999999999999999);
		System.out.println(bd.toString());
		System.out.println(max);
		System.out.println(d);
		System.out.println(1.0 / 0);
		Map<String, List<Integer>> map = new ConcurrentHashMap<String, List<Integer>>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		map.put("111", l1);
		List<Integer> l2 = new ArrayList<>();
		l2.add(2);
		List<Integer> l = map.putIfAbsent("111", l2);
		System.out.println(l);
		// map.put("111", l2);
		for (List<Integer> entry : map.values()) {
			for (Integer i : entry) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
