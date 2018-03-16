package funxing;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		List<Father> list = new ArrayList<>();
		list.add(new Father());
		list.add(new Son());
	}
}
