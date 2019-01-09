package mytest;

public class ThreadStateTest {
	public static volatile Thread t;

	public static void main(String[] args) {
		t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("000000");
			}
		});
		t.start();
		// t.start();//多次调用start会抛出illegalthreadstateexception
		// t.setDaemon(true);//
		// 先调用start，后设置守护进程标记，会抛出illegalthreadstateexception
		t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("000000");
			}
		});
		t.start();

	}
}
