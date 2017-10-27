package atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
	public static void main(String[] args) {
		AtomicIntegerFieldUpdaterTest temp = new AtomicIntegerFieldUpdaterTest();
		temp.doit();
	}

	AtomicIntegerFieldUpdater<DemoData> getUpdate(String fieldName) {
		return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
	}

	void doit() {
		DemoData data = new DemoData();
		System.out.println("1===>" + getUpdate("value1").getAndSet(data, 10));
		System.out.println("2===>" + getUpdate("value2").incrementAndGet(data));
		System.out.println("3===>" + getUpdate("value3").decrementAndGet(data));
		System.out.println(getUpdate("value1").get(data));
		System.out.println(
				"4===>" + getUpdate("value4").compareAndSet(data, 4, 5));
	}

}

class DemoData {
	public volatile int value1 = 1;
	volatile int value2 = 2;
	protected volatile int value3 = 3;
	private volatile int value4 = 4;
}
