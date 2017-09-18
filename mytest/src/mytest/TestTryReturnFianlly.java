package mytest;

public class TestTryReturnFianlly {
	public static void main(String[] args) {
		System.out.println(test());
	}

	private static int test() {
		int i = 2;
		try {
			i = 3;
			return i;
		} finally {
			i = 4;
		}
	}
}
