package java8.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 规约与汇总
 * 
 * @since 2018年3月22日 下午4:26:55
 * @author xchao
 */
public class Main02 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("123", "3456", "56789");
		// 使用Collectors的统计方法
		Long size = list.stream().collect(Collectors.counting());
		System.out.println(size);
		// 使用流的统计方法
		System.out.println(list.stream().count());

		Comparator<String> com = Comparator.comparingInt(String::length);
		Optional<String> o = list.stream().collect(Collectors.maxBy(com));
		System.out.println(o.get());

		int sum = list.stream().collect(Collectors.summingInt(String::length));
		System.out.println(sum);
		Double aver = list.stream()
				.collect(Collectors.averagingInt(String::length));
		System.out.println(aver);

		IntSummaryStatistics total = list.stream()
				.collect(Collectors.summarizingInt(String::length));
		System.out.println(total);

		String rs = list.stream().collect(Collectors.joining(","));
		System.out.println(rs);

		int totalLength = list.stream().collect(
				Collectors.reducing(0, String::length, (i, j) -> i + j));
		System.out.println(totalLength);

		Optional<String> ss = list.stream().collect(Collectors
				.reducing((s1, s2) -> s1.length() > s2.length() ? s1 : s2));
		System.out.println(ss.get());

		Integer a = list.stream().reduce(0, (s1, s2) -> s1 + s2.length(),
				(s1, s2) -> s1 + s2);
		System.out.println("======" + a);
	}
}
