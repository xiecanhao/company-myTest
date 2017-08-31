package mytest;

public class Activity {
	public static final int TOTAL_COUNT = 3;

	public static void main(String[] args) {
		PersonData data = new PersonData();
		boolean flag = false;
		try {
			int count = data.lock();
			if (TOTAL_COUNT - count > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			data.unlock(flag);
		}

	}
}
