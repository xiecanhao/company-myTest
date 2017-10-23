package mytest;

/**
 * break可以跳出指定的语句块，不一定要在for循环中
 */
public class BreakBlock {
	public static void main(String[] args) {
		System.out.println("label out start");
		label: {
			System.out.println("label block start");
			if (true) {
				break label;
			}
			System.out.println("label block end");//
		}
		System.out.println("label out end");
	}
}
