package mytest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TestHashMap {
	public static void main(String[] args) {
		Map<Integer, Test> map = new HashMap<>();
		map.put(1, new Test(1, "aa"));
		map.put(2, new Test(2, "bb"));
		map.put(3, new Test(3, "cc"));
		Iterator<Entry<Integer, Test>> it = map.entrySet().iterator();
		int i = 1;
		while (it.hasNext()) {
			Entry<Integer, Test> temp = it.next();
			System.out.println(temp.getKey() + "----" + temp.getValue().i);
			// it.remove();
			map.remove(i);
			i++;
			System.out.println(map.keySet());
			System.out.println(map.size());
		}
		// Map<Integer, Test> map2 = new HashMap<>();
		// map2.putAll(map);
		// map.get(3).i = 4;
		//
		// System.out.println(map2.get(3).i);
	}
}

class Test {
	int i = 0;
	String aa = "123";

	public Test(int i, String aa) {
		super();
		this.i = i;
		this.aa = aa;
	}

}
