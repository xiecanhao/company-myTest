package delay;

import java.util.concurrent.DelayQueue;

public class Client {
	public static void main(String[] args) {
		DelayQueue<DelayJob> queue = new DelayQueue<>();
		queue.offer(new DelayJob("end", System.currentTimeMillis() + 10000));
		boolean flag = false;
		int num = 1;
		while (!queue.isEmpty()) {
			try {
				DelayJob job = queue.take();
				job.fire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (num < 3) {
				queue.offer(new DelayJob("before" + num,
						System.currentTimeMillis() - num * 1000));
				num++;
			}
		}
	}
}
