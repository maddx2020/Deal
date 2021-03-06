package by.academy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Inherited
public @interface ProduserInfo {

	String name();

	String company();

	String[] prodyctTypes();

	int partNumber();

}
