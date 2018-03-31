package java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 归约
 * 
 * @since 2018年3月20日 下午4:47:57
 * @author xchao
 */
public class Main04 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		// ruduce 初始值，BinaryOperator
		int sum = list.stream().filter(n -> n > 5).map(n -> n * 2).reduce(0,
				(a, b) -> a + b);
		System.out.println(sum);
		Optional<Integer> optional = list.stream().reduce(Integer::max);
		System.out.println(optional.get());
		// ifPresent如果存在值，则执行对应的consumer
		optional.ifPresent(s -> System.out.println(s));
		optional = Optional.empty();
		// 获取值，如果不存在，则执行给定的Supplier
		System.out.println(optional.orElseGet(() -> Integer.MAX_VALUE));
		// 如果值不存在，则用给定的默认值
		System.out.println(optional.orElse(10));
	}
}
