package mytest;

public class Main2 {
	public static void main(String[] args) {
		// String sid = "[1, 2, 3, 5, 6, 7, 8, 9, 10, 9999]";
		// sid = sid.replaceAll("[\\[\\]]", "");
		// System.out.println(sid);
		float f = 5.136464f;
		f = Float.parseFloat(String.format("%.4f", f));
		System.out.println(f);
		int i = 0B01_10;
		System.out.println(i);
	}
}
