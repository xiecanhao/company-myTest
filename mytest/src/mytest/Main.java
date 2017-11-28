package mytest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Object o;
		Thread t;
		Integer i1 = 1;
		System.out.println(i1.hashCode());
		Integer i2 = 2;
		System.out.println(i2.hashCode());
		Integer i15 = 15;
		System.out.println(i15.hashCode());
		Integer i16 = 16;
		System.out.println(i16.hashCode());
		System.out.println((1L << 64L));
		System.out.println((1 >>> 60));
		System.out.println("main");
		/*
		 * String s = "0006"; Integer i = Integer.valueOf(s);
		 * System.out.println(i);
		 */
		String e = System.getProperty("user.dir");
		System.out.println(e);
		int a = 11;
		int b = a >> 1;
		System.out.println(b);
		ArrayList<Main> list = new ArrayList<Main>();
		list.add(new Main());
		Main m = new Main();
		Main m2 = new Main();
		System.out.println(m.equals(m2));
		System.out.println(m2);
		System.out.println(m.hashCode());
		int i = 5 - 1 & 3;// 0
		System.out.println(i);

		String s3 = new String("1") + new String("1");
		s3.intern();
		String s4 = "11";
		System.out.println(s3 == s4);

		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
		testStringIntern();
	}

	/*
	 * @Override public boolean equals(Object arg0) { // TODO Auto-generated
	 * method stub return true; }
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}

	private static void testStringIntern() {
		String s1 = new StringBuilder("go").append("od").toString();
		System.out.println(s1 == s1.intern());

		String s2 = new StringBuilder("ja").append("va").toString();
		System.out.println(s2 == s2.intern());

		String s3 = new StringBuilder("jaa").append("va").toString();
		System.out.println(s3 == s3.intern());

		String s4 = new StringBuilder("jaaaa").append("va").toString();
		System.out.println(s4 == s4.intern());
	}

}
