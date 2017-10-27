package mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试comparable返回0的情况 结果：不改变位置
 */
public class TestComparable {
	public static void main(String[] args) {
		List<Entity> list1 = new ArrayList<>();
		List<Entity> list2 = new ArrayList<>();
		Entity t1 = new Entity(10, "t1");
		Entity t2 = new Entity(10, "t2");
		list1.add(t1);
		list1.add(t2);
		list2.add(t2);
		list2.add(t1);
		Collections.sort(list1);
		Collections.sort(list2);
		System.out.println("list1");
		for (Entity t : list1) {
			System.out.println(t.name);
		}
		System.out.println("list2");
		for (Entity t : list2) {
			System.out.println(t.name);
		}
	}
}

class Entity implements Comparable<Entity> {
	int age;
	String name;

	public Entity(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Entity o) {
		return 0;
	}

}
