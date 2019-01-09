package annotation.packageInfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注在包上面的注解
 * 
 * @since 2018年7月12日 下午8:15:53
 * @author xchao
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyPkgAnnotation {

}
