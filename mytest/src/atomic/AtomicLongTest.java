package atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * AtomicLong的源码解析和使用，AtomicInteger和AtomicBoolean同个道理 AtomicBoolean b;//
 * 使用AtomicInteger进行封装
 * 使用sun.misc.Unsafe进行内存操作，根据元素的起始位置与偏移量，进行CAS（compareAndSet）执行操作
 * 
 * @since 2017年10月23日 下午4:24:48
 * @author xchao
 */
public class AtomicLongTest {
	public static void main(String[] args) {
		AtomicLong l = new AtomicLong();
		l = new AtomicLong(13);
		System.out.println(l.addAndGet(2));// 增加后返回值
		System.out.println(l.getAndAdd(2));// 返回值后增加
		System.out.println(l.get());
		l.set(12);
		l.incrementAndGet();
		System.out.println(l.get());
		l.decrementAndGet();
		System.out.println(l.get());
		l.lazySet(14);// 最终设定为某一个值
		System.out.println(l.get());
		System.out.println(l.compareAndSet(13, 12));// 如果当前值为参数1的值，则设置为参数2的值
		System.out.println(l.compareAndSet(14, 12));
		System.out.println(l.weakCompareAndSet(13, 15));// 如果当前值为参数1的值，则设置为参数2的值。与compareAndSet方法一致
		System.out.println(l.weakCompareAndSet(12, 15));
		System.out.println(l.get());
		System.out.println(l.updateAndGet(new LongOperation()));// 使用操作运算对AtomicLong的值进行计算
		System.out.println(l.getAndUpdate(new LongOperation()));
		l.set(10);
		System.out.println(l.getAndAccumulate(2, new LongBinaryOperator() {

			/**
			 * @Param atomicLong 操作的AtomicLong的值
			 * @Param myArgument 调用getAndAccumulate或者accumulateAndGet的第一个参数值
			 */
			@Override
			public long applyAsLong(long atomicLong, long myArgument) {
				return atomicLong * 2 + myArgument;
			}

		}));
		System.out.println(l.get());
	}
}

/**
 * 
 * 用于AtomicLong的getAndUpdate和updateAndGet方法
 */
class LongOperation implements LongUnaryOperator {

	@Override
	public long applyAsLong(long arg0) {
		long temp = (arg0 + 2) * 2;
		return temp;
	}

}
