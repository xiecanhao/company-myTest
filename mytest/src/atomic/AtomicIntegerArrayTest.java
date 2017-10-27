package atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class AtomicIntegerArrayTest {
	public static void main(String[] args) {
		// int arra[] = { 1, 2, 3 };
		// int arra2[] = arra.clone();//数组的克隆
		// System.out.println(arra.equals(arra2));
		/*
		 * AtomicIntegerArrayTest a[] = new AtomicIntegerArrayTest[2]; a[0] =
		 * new AtomicIntegerArrayTest(); AtomicIntegerArrayTest a2[] =
		 * a.clone();//浅复制 System.out.println("a[0]:" + a[0]);
		 * System.out.println("a2[0]:" + a2[0]);
		 */
		System.out.println(
				"**********************AtomicIntegerArray*********************");
		AtomicIntegerArray arr = new AtomicIntegerArray(10);
		System.out.println("arr init value:" + arr.get(0));// 初始化为0，int的默认值
		arr.set(0, 2);// 设置数组的某一个位置的值
		System.out.println(arr.get(0));
		arr.lazySet(1, 2);
		System.out.println("lazySet:" + arr.get(1));
		System.out.println("getAndSet:" + arr.getAndSet(2, 3));
		System.out.println(arr.get(2));
		System.out.println("compareAndSet:" + arr.compareAndSet(3, 1, 4));// 预期值值不相等则不操作
		System.out.println(arr.get(3));
		System.out.println("compareAndSet:" + arr.compareAndSet(3, 0, 4));// 预期值值相等则改为设定值
		System.out.println(arr.get(3));
		System.out.println("getAndIncrement:" + arr.getAndIncrement(4));// i++,调用getAndAdd
		System.out.println("incrementAndGet:" + arr.incrementAndGet(4));// ++i，调用addAndGet
		System.out.println("getAndAdd:" + arr.getAndAdd(5, 2));
		System.out.println("addAndGet:" + arr.addAndGet(5, 2));
		System.out.println("getAndDecrement:" + arr.getAndDecrement(6));// i--调用getAndAdd
		System.out.println("decrementAndGet:" + arr.decrementAndGet(6));// --i调用addAndGet

		System.out.println(
				"getAndUpdate:" + arr.getAndUpdate(7, new IntUnaryOperator() {

					@Override
					public int applyAsInt(int arg0) {
						return arg0 + 7;
					}
				}));
		System.out.println(
				"updateAndGet:" + arr.updateAndGet(7, new IntUnaryOperator() {

					@Override
					public int applyAsInt(int arg0) {
						return arg0 + 7;
					}
				}));

		System.out.println("getAndAccumulate:"
				+ arr.getAndAccumulate(8, 8, new IntBinaryOperator() {

					@Override
					public int applyAsInt(int arrValue, int paramValue) {
						return arrValue + 1 + paramValue * 2;
					}
				}));
		System.out.println("accumulateAndGet:"
				+ arr.accumulateAndGet(8, 8, new IntBinaryOperator() {

					@Override
					public int applyAsInt(int arrValue, int paramValue) {
						return arrValue + 1 + paramValue * 2;
					}
				}));
		System.out.println("toString:" + arr.toString());
		System.out.println(
				"************************AtomicInteger*********************");
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
