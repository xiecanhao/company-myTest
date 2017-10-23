package atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
	public static void main(String[] args) {
		AtomicIntegerArray arr;
		AtomicInteger integer = new AtomicInteger(3);
		System.out.println(integer.getAndIncrement());
		System.out.println(integer.get());
		integer.set(3);
		System.out.println(integer.incrementAndGet());
		System.out.println(integer.get());
		System.out.println(integer.compareAndSet(3, 5));
		System.out.println(integer.get());
	}
}
