package java8.chapter5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main07 {
	public static void main(String[] args) {
		Stream<int[]> arr = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
						.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.mapToObj(b -> new int[] { a, b,
								(int) Math.sqrt(a * a + b * b) }));
		System.out.println(arr.count());
		// arr.limit(3).forEach(
		// (a) -> System.out.println(a[0] + "," + a[1] + "," + a[2]));
		Stream<double[]> arr2 = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
						.mapToObj(b -> new double[] { a, b,
								Math.sqrt(a * a + b * b) })
						.filter(c -> c[2] % 1 == 0));

	}
	// * 流的创建方式：
	// * 1、集合创建 Collection.stream()
	// * 2、数组创建Arrays.stream()
	// * 3、值创建 Stream.of(...)
	// * 4、文件创建 Files.lines(...)
	// * 5、iterate和generate 例如IntStream.iterate
}
