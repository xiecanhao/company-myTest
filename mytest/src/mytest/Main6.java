package mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main6 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(Arrays.asList(list));
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer temp = it.next();
			if (temp == 5) {
				it.remove();
				break;
			}
		}
		System.out.println(Arrays.asList(list));
		if (true) {
			return;
		}

		// 模拟group数据
		Map<Integer, User> group = new HashMap<>();
		// group.put(1, new User(1, "xu1", 1));
		group.put(2, new User(2, "xu2", 2));
		group.put(2, new User(2, "xu2", 2));
		group.put(2, new User(2, "xu2", 2));
		group.put(3, new User(3, "xu3", 3));
		group.put(4, new User(4, "xu4", 4));
		Map<Integer, User> userMap = new HashMap<>();
		userMap.put(1, new User(1, "xu1", 1));
		userMap.put(2, new User(2, "xu2", 2));
		userMap.put(3, new User(3, "xu3", 3));
		userMap.put(4, new User(4, "xu4", 4));
		int count = 0;
		if (!userMap.isEmpty()) {
			Iterator<Entry<Integer, User>> iterator = userMap.entrySet()
					.iterator();
			while (iterator.hasNext()) {
				count++;
				Entry<Integer, User> entry = iterator.next();
				User guser = group.get(entry.getValue().getId());
				if (guser != null) {
					User user = new User(guser);
					userMap.put(user.getId(), user);
				} else {
					iterator.remove();
				}
				System.out.println(count);
			}
		}
	}

}
