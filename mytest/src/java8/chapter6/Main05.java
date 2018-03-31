package java8.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Main05 {
	public static void main(String[] args) {
		List<Person> ps = Arrays.asList(new Person(18, "tom1", 1.80),
				new Person(18, "tom2", 1.70), new Person(20, "tom3", 1.80),
				new Person(20, "tom4", 1.70));
		List<Person> list = ps.stream().collect(new MyListCollector<Person>());
		for (Person p : list) {
			System.out.println(p);
		}
	}

}

/**
 * 自己的toList collector
 * 
 * @param <T>
 * @since 2018年3月22日 下午7:52:56
 * @author xchao
 */
class MyListCollector<T> implements Collector<T, List<T>, List<T>> {

	// 返回容器类型
	@Override
	public Supplier<List<T>> supplier() {
		return ArrayList::new;
	}

	// 如何累加，参数为容器，新的元素
	@Override
	public BiConsumer<List<T>, T> accumulator() {
		return (List<T> list, T t) -> list.add(t);// List::add
	}

	// 多个容器的合并，用于多线程合并
	@Override
	public BinaryOperator<List<T>> combiner() {
		return (List<T> l1, List<T> l2) -> {
			l1.addAll(l2);
			return l1;
		};
	}

	// 收集完成后的转换方式，Funciton.identity()表示无需转换
	@Override
	public Function<List<T>, List<T>> finisher() {
		return Function.identity();
	}

	// CONCURRENT
	// UNORDERED
	// IDENTITY_FINISH
	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		return Collections.unmodifiableSet(
				EnumSet.of(Collector.Characteristics.IDENTITY_FINISH,
						Collector.Characteristics.CONCURRENT));
	}

}
