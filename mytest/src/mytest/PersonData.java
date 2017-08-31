package mytest;

import java.util.concurrent.locks.ReentrantLock;

public class PersonData {
	private ReentrantLock lock = new ReentrantLock();
	private int count = 0;

	public int lock() {
		lock.lock();
		return count;
	}

	public void unlock(boolean flag) {
		lock.unlock();
		if (flag) {
			count++;
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
