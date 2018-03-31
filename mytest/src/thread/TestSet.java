package thread;

import java.util.HashSet;
import java.util.Set;

/**
 * set的修改也是有可能出现多线程的快速失败问题
 * 
 * @since 2018年3月22日 上午10:30:57
 * @author xchao
 */
public class TestSet {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		new Thread(() -> {
			int i = 0;
			while (true) {
				try {
					set.add(++i);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}).start();
		new Thread(() -> {
			while (true) {
				try {
					set.clear();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}).start();
	}
}
