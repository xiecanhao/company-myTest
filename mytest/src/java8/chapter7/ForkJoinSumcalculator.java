package java8.chapter7;

import java.util.concurrent.RecursiveTask;

/**
 * 分支合并算法（分治法的应用）
 * 
 * @since 2018年4月1日 上午12:10:19
 * @author xchao
 */
public class ForkJoinSumcalculator extends RecursiveTask<Long> {

	/**  */
	private static final long serialVersionUID = 1L;
	private final long[] numbers;
	private final int start;
	private final int end;
	public static final int MIN_LENGTH = 10;

	public ForkJoinSumcalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}

	public ForkJoinSumcalculator(long[] numbers, int start, int end) {
		super();
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		int length = end - start;
		if (length <= MIN_LENGTH) {
			return computeSequentially();
		}
		ForkJoinSumcalculator left = new ForkJoinSumcalculator(numbers, start,
				start + length / 2);
		left.fork();
		ForkJoinSumcalculator right = new ForkJoinSumcalculator(numbers,
				start + length / 2, end);
		long ri = right.compute();

		return ri + left.join();
	}

	private long computeSequentially() {
		long sum = 0;
		for (int i = start; i < end; i++) {
			sum += numbers[i];
		}
		return sum;
	}

}
