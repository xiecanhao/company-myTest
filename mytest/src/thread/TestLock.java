package thread;

public class TestLock {
	public static int count = 0;
	public static Object lock = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TargetClass.method1();
				} catch (InterruptedException e) {
					System.out.println("t1 exception");
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TargetClass.method1();
				} catch (InterruptedException e) {
					System.out.println("t2 exception");
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
}

class TargetClass {
	public static void method1() throws InterruptedException {
		synchronized (TestLock.lock) {
			TestLock.count++;
			TestLock.lock.wait(5000);
			System.out.println(TestLock.count);
		}
	}
}
