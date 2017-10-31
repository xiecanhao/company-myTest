package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantReadWriteLockDemo {
	static ReadLock rlock = null;

	public static void main(String[] args) throws InterruptedException {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				rlock = lock.readLock();
				System.out.println("new thread readLock");

			}
		});
		t.start();
		WriteLock writeLock = lock.writeLock();
		System.out.println("main writeLock");
		ReadLock readLock = lock.readLock();
		System.out.println("main readLock");

	}
}
