package mytest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class Main9 {
	static ConcurrentHashMap<Integer, TestConst> map = new ConcurrentHashMap<>();

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cd = new CountDownLatch(2);
		for (int i = 0; i <= 100; i++) {
			map.put(i, new TestConst(i, i));
		}
		Runnable run = () -> {

		};
		Thread t2 = new Thread();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 100; i > 0; i--) {
					if (i == 10) {
						// try {
						// cd.await();
						// } catch (InterruptedException e) {
						// // TODO Auto-generated catch block
						// e.printStackTrace();
						// }
					}
					TestConst a = map.get(i);
					a.j = 100 + i;
					System.out.println("change");
				}
			}
		});
		t1.start();
		for (int i = 0; i < 100; i++) {
			if (i == 10) {
				Thread.sleep(1000);
				// try {
				// cd.await();
				// } catch (InterruptedException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
			}
			System.out.println(map.get(i));
		}
	}

	public enum State {
		STATE1(1, 1), STATE2(2, 2);
		private int i;
		private int j;

		private State(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}

	}
}

class TestConst {
	int i = 0;
	int j = 0;

	public TestConst(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	static {
		System.out.println("TestConst");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return i + "-----" + j;
	}

	public static final String SASS = "13231";
}
