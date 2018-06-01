package thread;

import java.util.concurrent.Semaphore;

public class SemaPhoreTest {
	public static void main(String[] args) {
		Semaphore sm = new Semaphore(1);
		new Thread(() -> {
			try {
				System.out.println("Thread 1 start");
				sm.acquire();
				System.out.println("Thread 1 sleep start");
				Thread.currentThread().sleep(1000L);
				System.out.println("Thread 1 sleep end");
				sm.release();
				System.out.println("Thread 1 end");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				System.out.println("Thread 2 start");
				sm.acquire();
				System.out.println("Thread 2 sleep start");
				System.out.println("Thread 2 sleep end");
				sm.release();
				System.out.println("Thread 2 end");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		System.out.println("main end");
	}
}
