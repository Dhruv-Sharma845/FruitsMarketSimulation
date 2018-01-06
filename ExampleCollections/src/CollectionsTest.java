import java.util.*;
import java.io.*;

public class CollectionsTest {

	public static void main(String[] args)
	{
		/*List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("ghi");
		
		display(list);
		
		Collections.reverse(list);
		
		display(list);
		*/
		
		//StringComparator comp=new StringComparator();
		
		//String maxElement = Collections.max(list,comp);
		
		//System.out.println("MAX is: " + maxElement);
		
		
		
		try
		{
			Address ad1=new Address("123","Ashok Vihar","Delhi");
			Employee e1=new Employee(1,"Dhruv",ad1,"xyz");
		
			Address ad2=new Address("123","Ashok Vihar","Delhi");
			Employee e2=new Employee(2,"Sharma",ad2,"abc");
			
			/*EmployeeComparator ec=new EmployeeComparator();
			
			Map<Employee,String> mp=new TreeMap<Employee,String>(ec);
			mp.put(e2, "Sharma");
			mp.put(e1, "Dhruv");
			
			//mp.put(3, "xyz");
			//String x = (String)mp.put(1, "abc");
			
			//System.out.println("Older Value is" + x);
			
			Set s=mp.entrySet();
			
			Iterator it=s.iterator();
			while(it.hasNext())
			{
				Map.Entry temp=(Map.Entry)it.next();
				System.out.println(temp.getKey() + " " + temp.getValue());
			}*/
			String FilePath="temp.txt";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FilePath));
			oos.writeObject(e1);
			oos.writeObject(e2);
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePath));
			e1=(Employee) ois.readObject();
			e2=(Employee) ois.readObject();
			
			ois.close();
			
			System.out.println(e1);
			System.out.println(e2);
			
		}
		catch(CloneNotSupportedException ce)
		{
			ce.printStackTrace();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void display(List<String> list)
	{
		Iterator<String> it=list.iterator();
		
		while(it.hasNext())
		{
			System.out.print(it.next()+ "  ");
		}
		System.out.println("");
	}
}
