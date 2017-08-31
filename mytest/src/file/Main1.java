package file;

public class Main1 {
	public static void main(String[] args) {
		// 取得根目录路径
		String rootPath = Main1.class.getResource("/").getFile().toString();
		// 当前目录路径
		String currentPath1 = Main1.class.getResource(".").getFile().toString();
		String currentPath2 = Main1.class.getResource("").getFile().toString();
		// 当前目录的上级目录路径
		String parentPath = Main1.class.getResource("../").getFile().toString();

		System.out.println(rootPath);
		System.out.println(currentPath1);
		System.out.println(currentPath2);
		System.out.println(parentPath);
	}
}
