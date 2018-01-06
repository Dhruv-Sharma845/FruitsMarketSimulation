import java.lang.*;
import java.util.*;
import java.io.Serializable;


public class Employee implements Comparable<Employee>,Serializable {
	private int ID;
	private String Name;
	private Address add;
	private transient String Password;
	
	public Employee(int _ID,String _Name,Address _add,String Password) throws CloneNotSupportedException
	{
		this.ID = _ID;
		this.Name = _Name;
		this.add = (Address) _add.clone();
	}
	public Address getAddress() throws CloneNotSupportedException 
	{
		return (Address) add.clone();
	}
	
	public String getName()
	{
		return Name;
	}
	public String toString()
	{
		return ID + "  " + Name + "  " + add.toString() + "  " + Password;
	}
	
	public int compareTo(Employee a)
	{
		return this.ID - a.ID; 
	}
}

