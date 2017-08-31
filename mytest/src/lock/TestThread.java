package lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
	private static MyLock lock = new MyLock();

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Thread current = Thread.currentThread();
				try {
					lock.lock();
					System.out
							.println(current.getId() + ":" + current.getName());
					Thread.sleep(5000);
					List<Thread> threads = lock.getQueuedThreads();
					for (Thread t : threads) {
						System.out.println("stop thread-----" + t.getId() + ":"
								+ t.getName());
						// t.interrupt();// 无法停止其他等待线程
						// t.destroy();//无法停止其他等待线程
						t.stop();
					}
					System.out.println("first Thread end");
				} catch (Exception e) {
					System.out.println("thread error" + current.getId());
				} finally {
					lock.unlock();
				}

			}
		}).start();

		Thread.sleep(1000);
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						lock.lock();
						System.out.println(
								Thread.currentThread().getId() + " get lock");
					} catch (Exception e) {
						System.out.println("thread error:"
								+ Thread.currentThread().getId());
					} finally {
						try {
							lock.unlock();
						} catch (Exception e2) {
							System.out.println(
									Thread.currentThread().getId() + "unlock");
						}
					}

				}
			}).start();
		}
	}

	static class MyLock extends ReentrantLock {
		/**  */
		private static final long serialVersionUID = 1L;

		public List<Thread> getQueuedThreads() {
			List<Thread> threads = new ArrayList<Thread>(
					super.getQueuedThreads());
			Collections.reverse(threads);
			return threads;
		}
	}
}
