package mytest;

/**
 * 构造代码块会按照构造代码块的顺序，放在构造函数执行的前面
 * 
 * @since 2018年3月26日 下午12:03:38
 * @author xchao
 */
public class TestBlockCode {
	public static void main(String[] args) {
		new B();
	}
}

class A {
	public A() {
		System.out.println("a()");
	}

	{
		System.out.println("a block");
	}
	static {
		System.out.println("a static block");
	}
}

class B extends A {
	public B() {
		System.out.println("b()");
	}

	{
		System.out.println("bbbbb");
	}
	{
		System.out.println("b block");
	}
	static {
		System.out.println("b static block");
	}
}
