package mytest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RemovePoint {
	public static void main(String[] args) {
		// x->y点集合
		Map<Integer, Set<Integer>> totalPoints = new HashMap<>();
		Map<Integer, Integer> removePoints = new HashMap<>();
		Map<Integer, Integer> hasRemove = new HashMap<>();
		for (Entry<Integer, Integer> entry : removePoints.entrySet()) {
			Integer x = entry.getKey();
			Integer y = entry.getValue();
			Set<Integer> set = totalPoints.get(x);
			// 不存在
			if (set == null || set.isEmpty() || !set.contains(y)) {
				// TODO 加回hasRemove的点
				break;
			}
			set.remove(y);
			hasRemove.put(x, y);
		}
	}
}
