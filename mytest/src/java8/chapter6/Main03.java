package java8.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 分组
 * 
 * @since 2018年3月22日 下午4:26:28
 * @author xchao
 */
public class Main03 {
	public static void main(String[] args) {
		List<Person> ps = Arrays.asList(new Person(18, "tom1", 1.80),
				new Person(18, "tom2", 1.70), new Person(20, "tom3", 1.80),
				new Person(20, "tom4", 1.70));
		Map<Integer, List<Person>> ls = ps.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		for (Entry<Integer, List<Person>> en : ls.entrySet()) {
			System.out.println(en.getKey());
			for (Person p : en.getValue()) {
				System.out.println(p);
			}
		}
		// 二级分组,可继续设置多级分组
		Map<Integer, Map<Double, List<Person>>> ls2 = ps.stream()
				.collect(Collectors.groupingBy(Person::getAge,
						Collectors.groupingBy(Person::getHight)));
		for (Entry<Integer, Map<Double, List<Person>>> en : ls2.entrySet()) {
			System.out.println(en.getKey());
			Map<Double, List<Person>> temp = en.getValue();
			for (Entry<Double, List<Person>> tt : temp.entrySet()) {
				System.out.println(tt.getKey());
				for (Person p : tt.getValue()) {
					System.out.println(p);
				}
			}
		}
		System.out.println("*********************");
		Map<Integer, Object> rs = ps.stream()
				.collect(
						Collectors.groupingBy(Person::getAge,
								Collectors.collectingAndThen(
										Collectors.maxBy(Comparator
												.comparing(Person::getHight)),
										Optional::get)));
		for (Entry<Integer, Object> en : rs.entrySet()) {
			System.out.println(en.getKey() + ":" + en.getValue());
		}
	}

}

class Person {
	private int age;
	private String name;
	private double hight;

	public Person(int age, String name, double hight) {
		super();
		this.age = age;
		this.name = name;
		this.hight = hight;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public double getHight() {
		return hight;
	}

	@Override
	public String toString() {
		return name + "," + age + "," + hight;
	};

}
