package thinking_in_java.chapter2;

import java.util.Properties;

public class PrintSystemProperties {
	public static void main(String[] args) {
		Properties p = System.getProperties();
		p.list(System.out);
		System.out.println("Memory state");
		Runtime r = Runtime.getRuntime();
		System.out.println("total Memory:" + r.totalMemory()
				+ "\r\nfree Memory:" + r.freeMemory());
	}
}
