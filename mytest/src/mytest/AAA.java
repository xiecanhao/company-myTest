package mytest;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AAA {
	static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(
			19, 0);

	public static void main(String[] args) {
		// 充值线程
		for (int i = 0; i < 3; i++) {
			final int timestamp = money.getStamp();
			new Thread() {
				public void run() {
					forloop: while (true) {
						System.out.println("1");
						while (true) {
							Integer m = money.getReference();
							if (m < 20) {
								if (money.compareAndSet(m, m + 20, timestamp,
										timestamp + 1)) {
									System.out.println("余额小于20元，现充值20元，充值成功！余额:"
											+ money.getReference());
									break forloop;
								} else {
									System.out.println("余额大于20元或者已经充值过，充值失败！余额:"
											+ money.getReference());
									break forloop;
								}
							}
						}
					}
				}
			}.start();
		}

		try {
			Thread.sleep(3000);// 停顿三秒，让上一个循环运行完成
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// 消费线程
		new Thread() {

			public void run() {
				for (int i = 0; i < 100; i++) {
					while (true) {
						int timestamp = money.getStamp();
						Integer m = money.getReference();
						if (m > 10) {
							System.out.println("大于10元");
							if (money.compareAndSet(m, m - 10, timestamp,
									timestamp + 1)) {
								System.out.println(
										"成功消费10元，余额：" + money.getReference());
								break;
							}
						} else {
							System.out.println("没有足够的金额");
							break;
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO: handle exception
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					}
				}
				;
			}
		}.start();
	}
}
