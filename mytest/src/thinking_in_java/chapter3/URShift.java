package thinking_in_java.chapter3;

public class URShift {
	public static void main(String[] args) {
		int i = -1;
		i >>>= 10;
		System.out.println("i:" + i);
		long l = -1l;
		l >>>= 10;
		System.out.println("l:" + l);
		short s = -1;
		s >>>= 10;
		System.out.println("s:" + s);
		byte b = -1;
		b >>>= 10;
		System.out.println("b:" + b);
		System.out.println((1 << 31) & 1);
	}
}
