package mytest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OnlineJava {
	public static final String URL = "D:" + File.separator + "testOnline"
			+ File.separator + "Main.java";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader(new File("code.txt")));
		String code = "";
		String line = null;
		File file = new File("D:\\testOnline\\Main.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		while ((line = br.readLine()) != null) {
			code += line;
			bw.write(line);
			bw.newLine();
		}
		System.out.println(code);
		bw.flush();
		br.close();
		bw.close();
		file.renameTo(new File("D:\\testOnline\\Main.java"));

		// 运行文件
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec("cmd.exe /c start javac D:\\testOnline\\Main.java");
		// Process p = rt.exec("cmd.exe /c start javac
		// D:\\testOnline\\Main.java");
		// printStream(p.getErrorStream());
		// printStream(p.getInputStream());
		System.out.println(p.getOutputStream());
		if (p != null) {
			p.destroy();
			p = null;
		}
		// String commands[] = { "cd D:" + File.separator + "testOnline",
		// "javac Main.java" };
		// rt.exec(commands);
	}

	private static void printStream(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String result = "", line = null;
		while ((line = br.readLine()) != null) {
			result += line;
		}
		System.out.println(result);
		br.close();
	}
}
