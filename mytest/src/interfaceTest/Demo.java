package interfaceTest;

public class Demo implements FirstInterface, SecondInterface {

	@Override
	public void printSS() {

	}

	@Override
	public void print() {

	}

	@Override
	public void printDefaule() {
		System.out.println("my printDefaule");
		FirstInterface.super.printDefaule();
		SecondInterface.super.printDefaule();
	}

	public static void main(String[] args) {
		new Demo().printDefaule();
	}

}
