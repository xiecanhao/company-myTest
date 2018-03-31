package java8.chapter7;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main01 {
	public static void main(String[] args) {
		// 修改流并行处理的线程数量
		System.setProperty(
				"java.util.concurrent.ForkJoinPool.common.parallelism", "10");
		// 获取当前cpu的核数
		System.out.println(Runtime.getRuntime().availableProcessors());
		// 顺序增加的耗时
		System.out.println("normal:" + measureSumPerf((Long n) -> Stream
				.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum), 100));
		// 并行流增加的耗时
		System.out.println("parallel:"
				+ measureSumPerf((Long n) -> Stream.iterate(1L, i -> i + 1)
						.limit(n).parallel().reduce(0L, Long::sum), 100));
		// 顺序增加的耗时
		System.out.println("rangeSum:" + measureSumPerf(Main01::rangeSum, 100));
		// 并行流增加的耗时
		System.out.println("parallelRangeSum:"
				+ measureSumPerf(Main01::parallelRangeSum, 100));

	}

	public static long rangeSum(long n) {
		return LongStream.rangeClosed(1, n).reduce(0l, Long::sum);
	}

	public static long parallelRangeSum(long n) {
		return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
	}

	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start);
			// System.out.println("Result:" + sum);
			// System.out.println(duration);
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}
}
