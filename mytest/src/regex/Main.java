package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\d{1,3}\\°\\d+\\'\\d+\"");
		Matcher m = p.matcher("120°13131315'4512313\"");
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
