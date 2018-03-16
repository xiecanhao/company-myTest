package mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main333 {
	public static void main(String[] args) {
		List<MyObject> list = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			list.add(new MyObject(1));
			list.add(new MyObject(2));
			list.add(new MyObject(3));
			list.add(new MyObject(1));
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}

class MyObject implements Comparable<MyObject> {
	int i = 0;

	public MyObject(int i) {
		super();
		this.i = i;
	}

	@Override
	public int compareTo(MyObject temp) {
		int val = this.i - temp.i;
		return val == 0 ? 0 : val > 0 ? 1 : -1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return i + "";
	}

}
