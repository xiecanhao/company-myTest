package atomic;

/**
 * sun.misc.Unsafe的实例调试
 * 
 * @since 2017年10月19日 下午8:56:03
 * @author xchao
 */
public class TestUnsafe {
	public static void main(String[] args) {
		// Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal
		// reference
		// f.setAccessible(true);
		// Unsafe unsafe = (Unsafe) f.get(null);
		//
		// // This creates an instance of player class without any
		// initialization
		// Player p = (Player) unsafe.allocateInstance(Player.class);
		// System.out.println(p.getAge()); // Print 0
		//
		// p.setAge(45); // Let's now set age 45 to un-initialized object
		// System.out.println(p.getAge()); // Print 45
	}
}

class Player {
	private int age = 12;

	private Player() {
		this.age = 50;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}