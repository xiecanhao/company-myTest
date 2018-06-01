package mytest;

public class Main12 {
	public static void main(String[] args) {
		System.out.println(Short.MAX_VALUE);
		short s = (short) (2 << 10 + 100);
		short target = 100;
		System.out.println(s);
		System.out.println(s & (2 << 10));
		System.out.println(target & (2 << 10));
		Father f = new Son();
		System.out.println(f.i);
		System.out.println(f.get());
		f.method();
		Integer i = 222;
		Integer j = 222;
		System.out.println(i + "," + j);
		System.out.println(i == j);
	}
}

class Father {
	public int i = 1;

	public void method() {
		System.out.println("father");
	}

	public int get() {
		return i;
	}
}

class Son extends Father {
	public int i = 2;

	@Override
	public void method() {
		System.out.println("son");
	}

	@Override
	public int get() {
		return i;
	}
}
