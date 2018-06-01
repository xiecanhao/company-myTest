package mytest;

import java.util.HashSet;
import java.util.Set;

public class Main13 {
	public static void main(String[] args) {
		int i = 11;
		int j = Integer.MIN_VALUE >>> 1;
		System.out.println(j);
		Set<Integer> set = new HashSet<>(64);
		set.add(1);
		set.add(4);
		set.add(3);
		System.out.println(set);
	}
}

class Class1 {
	Object obj;

	void method() {
		// 操作obj
	}

	Object getObj() {
		return obj;
	}
}

class Class2 {
	void operateMethod() {
		Class1 c1 = null;
	}
}
