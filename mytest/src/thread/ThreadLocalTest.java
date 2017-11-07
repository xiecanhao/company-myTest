package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ThreadLocalTest {
	public static void main(String[] args) throws InterruptedException {
		// ThreadLocal<Integer> tl;
		CountDownLatch cdl = new CountDownLatch(1);// 当countDown使得初始化的值为0时，释放await的线程
		CyclicBarrier cb = new CyclicBarrier(2);// 使得当前线程停止，当await的线程达到指定数量（初始化的数量），则放行所有线程
		Semaphore sp = new Semaphore(2);// 有限资源的集合
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(i);
				}
				// cdl.countDown();
			}
		});
		t.start();
		for (StackTraceElement temp : t.getStackTrace()) {
			System.out.println(temp);
		}
		t.join();
		// cdl.await();
	}
}
