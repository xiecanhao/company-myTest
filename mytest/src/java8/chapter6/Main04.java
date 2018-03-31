package java8.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 分区
 * 
 * @since 2018年3月22日 下午4:26:09
 * @author xchao
 */
public class Main04 {
	public static void main(String[] args) {
		List<Person> ps = Arrays.asList(new Person(18, "tom1", 1.80),
				new Person(18, "tom2", 1.70), new Person(20, "tom3", 1.80),
				new Person(20, "tom4", 1.70));
		Map<Boolean, List<Person>> map = ps.stream()
				.collect(Collectors.partitioningBy((p) -> p.getAge() > 19));
		for (Entry<Boolean, List<Person>> en : map.entrySet()) {
			System.out.println(en.getKey());
			for (Person p : en.getValue()) {
				System.out.println(p);
			}
		}
		Consumer<String> c = System.out::println;
		Map<Boolean, Map<Double, List<Person>>> map2 = ps.stream()
				.collect(Collectors.partitioningBy((p) -> p.getAge() > 19,
						Collectors.groupingBy(Person::getHight)));

	}
}
