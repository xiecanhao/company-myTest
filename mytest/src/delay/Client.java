package delay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		DelayQueue<DelayJob> queue = new DelayQueue<>();
		queue.offer(new DelayJob("end", System.currentTimeMillis() + 10000));
		boolean flag = false;
		int num = 1;
		exec.submit(new Runnable() {
			@Override
			public void run() {
				while (!queue.isEmpty()) {
					try {
						DelayJob job = queue.take();
						job.fire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		if (num < 3) {
			queue.offer(new DelayJob("before" + num,
					System.currentTimeMillis() - num * 1000));
			num++;
		}
	}
}
