package mytest;

import java.util.Scanner;

/**
 * 判断一个字符串是不是回文串
 * 
 * @since 2017年7月10日 下午3:32:08
 * @author xchao
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			String input = in.nextLine();
			if (isGet(input)) {
				System.out.println(input + " 是一个回文串.");
			} else {
				System.out.println(input + " 不是一个回文串.");
			}
		}
	}

	private static boolean isGet(String input) {
		if (null == input || "".equals(input)) {
			return false;
		}
		if (input.length() < 2) {
			return true;
		}
		int lastIndex = input.length() - 1;
		int headIndex = 0;
		char head, last;
		while (headIndex < lastIndex) {
			head = input.charAt(headIndex);
			last = input.charAt(lastIndex);
			if (head != last) {
				return false;
			}
			headIndex++;
			lastIndex--;
		}
		return true;
	}
}
