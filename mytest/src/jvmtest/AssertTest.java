package jvmtest;

/**
 * 测试断言的使用
 * 
 * @since 2018年3月23日 上午11:11:33
 * @author xchao
 */
public class AssertTest {
	public static void main(String[] args) {
		int i = -100;
		assert (i > 0);// 需要开启jvm参数
						// -ea,如果boolean为false，则抛出java.lang.AssertionError
		System.out.println(i);
	}
}
