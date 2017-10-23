package jvmtest;

/**
 * 
 * -XX:+PrintGCDetails
 */
public class TestClassMemory {
	public static final User user = new User();

	public static void main(String[] args) {
		TestClassMemory tc = new TestClassMemory();
		System.out.println(tc);
	}
}

class User {
	byte b1[] = null;

	public User() {
		super();
		this.b1 = new byte[1024 * 1024 * 50];
	}

}
