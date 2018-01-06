import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation 
{
	int value();
}
public class Hello {
	
	@MyAnnotation(value=10)
	public void sayHello()
	{
		System.out.println("Hello annotation");
	
	}
}
