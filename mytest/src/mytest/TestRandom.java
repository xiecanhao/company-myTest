package mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 随机打乱list的顺序
 * 
 * @since 2018年5月16日 下午6:31:11
 * @author xchao
 */
public class TestRandom {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int total = 20000;
		int limit = 10;
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			nums.add(i);
		}
		Collections.shuffle(nums);
		List<Integer> msg = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			msg.add(nums.get(i));
			limit--;
			if (limit < 1)
				break;
		}
		System.out.println(msg);
		System.out.println("cost:" + (System.currentTimeMillis() - start));
	}
}
