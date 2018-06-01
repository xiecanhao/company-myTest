package mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main11 {
	public static void main(String[] args) {
		int io = Integer.MAX_VALUE << 1;
		System.out.println(io);
		if (true)
			return;
		List<Demo11> list = new ArrayList<>();
		for (long i = 0; i < 100000; i++) {
			Demo11 d1 = new Demo11(System.currentTimeMillis());
			d1.test();
			list.add(d1);
		}
		list.add(new Demo11(Long.MAX_VALUE));
		list.add(new Demo11(Long.MIN_VALUE));
		for (long i = 0; i < 100; i++) {
			Demo11 d1 = new Demo11(0);
			list.add(d1);
		}
		Collections.sort(list);
		System.out.println("end");
	}
}

class Demo11 implements Comparable<Demo11> {
	private long num;

	public Demo11(long num) {
		super();
		this.num = num;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	@Override
	public int compareTo(Demo11 o) {
		return (int) (this.num - o.getNum());
	}

	protected void test() {
	}

}