package interfaceTest;

public interface FirstInterface {
	public void print();

	default public void printDefaule() {
		System.out.println("FirstInterface printDefaule");
	}
}
