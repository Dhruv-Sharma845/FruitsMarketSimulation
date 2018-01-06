
public class TestEmployee {

	public static void main(String[] args)
	{
		Address ad=new Address("123","Ashok Vihar","Delhi");
		try
		{
			Employee e=new Employee(1,"Dhruv",ad);
			
			ad.setCity("Bunkar Colony");
			
			System.out.println(e);
			System.out.println(ad);
		}
		catch(CloneNotSupportedException c)
		{
			c.getStackTrace();
		}
	}
}
