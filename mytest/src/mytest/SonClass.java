package mytest;

import java.util.HashMap;
import java.util.Map;

public final class SonClass extends SupperClass {
	Map<Integer, Integer> map = new HashMap<>();
	{
		System.out.println("son block" + map);

	}

	SonClass() {
		System.out.println("son");
		sonMethod();
	}

	public static void main(String[] args) {
		SonClass son = new SonClass();
		System.out.println(son.map);
	}

	@Override
	protected void sonMethod() {
		map = new HashMap<>();
		map.put(1, 1);
	}
}

abstract class SupperClass {

	SupperClass() {
		System.out.println("super");
		sonMethod();
	}

	protected abstract void sonMethod();

	{
		System.out.println("super block");
	}
}
