package lock;

public class TestSynchronized {
	public static boolean flag = true;
	public static boolean flag2 = true;

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (TestSynchronized.class) {
					System.out.println("t1 foward");
					try {
						while (flag) {
							TestSynchronized.class.notifyAll();
							TestSynchronized.class.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t1 after");
					TestSynchronized.class.notifyAll();
				}
				flag2 = false;
			}

		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (TestSynchronized.class) {
					System.out.println("t2 foward");
					try {
						while (flag2) {
							flag = false;
							TestSynchronized.class.notifyAll();
							TestSynchronized.class.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2 after");
				}
			}

		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
