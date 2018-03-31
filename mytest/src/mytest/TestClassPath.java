package mytest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestClassPath {
	public static void main(String[] args)
			throws FileNotFoundException, IOException {
		Properties p = new Properties();
		System.out.println(TestClassPath.class.getClassLoader());
		System.out.println(TestClassPath.class.getClassLoader()
				.getResource("aaa.properties"));
		p.load(new FileInputStream(new File("src/mytest/aaa.properties")));
		// p.load(new FileInputStream(new
		// File(TestClassPath.class.getClassLoader()
		// .getResource("aaa.properties").getFile())));
		System.out.println(p.get("a"));
	}
}
