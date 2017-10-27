package mytest;

import java.io.IOException;

public class ProcessBuilderDemo {
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("notepad.exe", "testfile");
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
