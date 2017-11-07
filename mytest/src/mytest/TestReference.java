package mytest;

/**
 * 检测java中只有值引用
 */
public class TestReference {
	public int i = 2;

	public static void main(String[] args) {
		TestReference a1 = new TestReference();
		TestReference a2 = new TestReference();
		System.out.println(a1);
		System.out.println(a2);
		swap(a1, a2);
		// 如果是引用传递，那么a1和12的地址值会交换。。。结果未改变
		System.out.println(a1);
		System.out.println(a2);
	}

	private static void swap(TestReference a1, TestReference a2) {
		TestReference temp = a1;
		a1 = a2;
		a2 = a1;
	}
}
