package mytest;

import java.util.ArrayList;
import java.util.List;

public class Main222 {
	public static void main(String[] args) {
		System.out.println((Math.log(0) / Math.log(2) - 1));
		System.out.println(89 % 3 / 1 ^ 10086 ^ 10086);
		System.out.println(Main222.class.getSimpleName());
		System.out.println(Main222.class.getName());
		int x = 0;
		int y = 2;
		y = --x | ++y;
		System.out.println(-1 | 3);
		System.out.println(y);
		List<Integer> list = new ArrayList<Integer>() {
			/**  */
			private static final long serialVersionUID = 1L;

			{
				add(1);
				add(2);
				add(3);
			}
		};
		list.remove(0);
		System.out.println(list.get(0));
	}
}
