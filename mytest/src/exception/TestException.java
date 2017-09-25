package exception;

public class TestException {
	public static void main(String[] args) {
		try {
			callmethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void callmethod() {
		try {
			System.out.println("try block");
			throw new IndexOutOfBoundsException();// 如果为检测异常没有捕获，则需要抛出异常
		} catch (ClassCastException e) {// catch没有捕获到异常，则抛出给调用者处理
			System.out.println("catch ClassCastException");
		} finally {
			System.out.println("finally block");
		}

	}
}
