import java.lang.reflect.*;
import java.util.*;
import java.lang.reflect.*;

public class TestCustomAnno {
	
	public static void main(String[] args)
	{
		Hello h=new Hello();
	
		Method m=null;
		try {
			m = h.getClass().getMethod("sayHello");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyAnnotation manno= m.getAnnotation(MyAnnotation.class);
	
		System.out.println("Value is: "+manno.value());
	}
}
