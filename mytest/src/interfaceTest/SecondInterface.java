package interfaceTest;

public interface SecondInterface {
	public void printSS();

	default public void printDefaule() {
		System.out.println("SecondInterface printDefaule");
	}
}
