package mytest;

public class Demo {
	public static void main(String[] args) {
		test((s) -> System.out.println("gasdfasfd"));
	}

	private static void test(InterfaceDemo demo) {
		demo.print("123456");

	}
}