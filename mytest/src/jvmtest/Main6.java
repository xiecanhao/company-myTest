package jvmtest;

/**
 * 
 * jvm参数 -Xms200m -Xmx200m -XX:+PrintGCDetails
 */
public class Main6 {
	public static final Users user = new Users();// user引用存在于方法区中，对象数据存在堆中

	public static void main(String[] args) throws InterruptedException {
		System.out.println("****");
		System.out.println(TestClassMemory.user);
		user.setNull();
		Thread.sleep(3000);
		System.gc();
		Thread.sleep(3000);
	}
}

class Users {
	byte b1[] = null;

	public Users() {
		super();
		this.b1 = new byte[1024 * 1024 * 50];
	}

	public void setNull() {
		b1 = null;
	}
}