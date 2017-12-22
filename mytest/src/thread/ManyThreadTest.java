package thread;

public class ManyThreadTest {
	public static void main(String[] args) {
		MyInstance m = new MyInstance(10, true);
		MyThread mt = new MyThread(m);
		new Thread(mt).start();
		m.set(20, false);
		System.out.println(m.flag);
		System.out.println(m.i);
	}

}

class MyInstance {
	int i;
	boolean flag;

	public MyInstance(int i, boolean flag) {
		super();
		this.i = i;
		this.flag = flag;
	}

	public void set(int i, boolean flag) {
		this.i = i;
		this.flag = flag;
	}
}

class MyThread implements Runnable {
	MyInstance m;

	public MyThread(MyInstance m) {
		this.m = m;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(m.flag);
		System.out.println(m.i);

	}

}