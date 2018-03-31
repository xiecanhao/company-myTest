package collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap不能用null作为key或者value
 * 
 * @since 2018年3月23日 上午11:27:51
 * @author xchao
 */
public class TestConcurrentHashMap {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new ConcurrentHashMap<>();
		map.put(null, 1);// java.lang.NullPointerException
		// map.put(1, null);//java.lang.NullPointerException

	}
}
