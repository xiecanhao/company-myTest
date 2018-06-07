package deadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DealLockDemo {
	private static Lock lock1 = new ReentrantLock();
	private static Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock1) {
					try {
						Thread.sleep(1000l);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock2) {
						System.out.println("t1");
					}
				}

			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock2) {
					try {
						Thread.sleep(1000l);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock1) {
						System.out.println("t2");
					}
				}

			}
		}, "t2");
		t1.start();
		t2.start();
		int i = 0;
		while (1 > 0) {
			i++;
			if (i >= Integer.MAX_VALUE)
				i = 0;
			System.out.println(i);
		}
	}
}
