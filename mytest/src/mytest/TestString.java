package mytest;

public class TestString {
	public static void main(String[] args) {
		String str = new String("aa");
		System.out.println("aa".hashCode());
		System.out.println(str.hashCode());
		System.out.println("aa" == str);
		str = str.intern();
		System.out.println("aa" == str);
	}
}
