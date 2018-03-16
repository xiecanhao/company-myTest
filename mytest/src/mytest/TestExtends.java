package mytest;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class TestExtends {
	class GrandFather {
		void thinking() {
			System.out.println("grandFather");
		}
	}

	class Father extends GrandFather {
		void thinking() {
			System.out.println("Father");
		}
	}
	class Father2 extends Father{
		void thinking() {
			System.out.println("Father2");
		}
	}

	class Son extends Father2 {
		void thinking() {
			System.out.println("son");
			try {
				MethodType mt = MethodType.methodType(void.class);
				MethodHandle mh = MethodHandles.lookup().findSpecial(
						GrandFather.class, "thinking", mt, getClass());
				mh.invoke(this);
			} catch (Throwable e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		new TestExtends().new Son().thinking();
	}
}
