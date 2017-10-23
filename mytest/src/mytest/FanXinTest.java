package mytest;

public class FanXinTest<F> {
	public <T, K, V> T getSomething(T t, K k, V v) {
		return t;
	}

	public F get(F f) {
		return f;
	}

	public static <F> F staticGet(F f) {
		return f;
	}

	public static void main(String[] args) {
		// AAA a = new AAA();
		// staticGet(a);
	}
}
