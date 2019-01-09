package annotation.packageInfo;

import java.lang.annotation.Annotation;

public class Client {
	public static void main(String[] args) {
		String pkgName = "annotation.packageInfo";
		Package pkg = Package.getPackage(pkgName);
		Annotation[] anos = pkg.getAnnotations();
		for (Annotation an : anos) {
			System.out.println(an);
			if (an instanceof MyPkgAnnotation) {
				System.err.println("i am MyPkgAnnotation");
			}
		}
	}

	void method() {

	}
}
