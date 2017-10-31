package atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * AtomicReference使得对对象的改变实现原子操作
 */
public class AtomicReferenceTest {
	public static void main(String[] args) {
		User user = new User(1, "111", 1);
		AtomicReference<User> ar = new AtomicReference<User>(user);
		System.out.println(ar.get());
		// 引用不一样，无法改变
		System.out.println(
				ar.compareAndSet(new User(1, "111", 1), new User(2, "222", 2)));
		// 成功改变引用
		System.out.println(ar.getAndSet(new User(2, "222", 2)));
		System.out.println(ar.get());
		// UnaryOperator的使用，apply方法操作传入旧的对象
		System.out.println(ar.updateAndGet(new UnaryOperator<User>() {

			@Override
			public User apply(User old) {

				return new User(old.getId(), old.getName() + "new",
						old.getAge() * 2);
			}
		}));
		// 根据传入参数和旧值进行操作
		System.out.println(ar.accumulateAndGet(new User(3, "333", 3),
				new BinaryOperator<User>() {

					@Override
					public User apply(User old, User param) {
						return new User(param.getId(),
								old.getName() + "-->" + param.getName(),
								param.getAge());
					}
				}));
		AtomicReferenceFieldUpdater aaa;
		AtomicReferenceArray<User> arr;
		AtomicStampedReference<User> asr;
		AtomicMarkableReference<User> amr;
	}
}

class User {
	private int id;
	private String name;
	private int age;

	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.id + "," + this.name + "," + this.age;
	}

}
