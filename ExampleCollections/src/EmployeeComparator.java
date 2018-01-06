import java.util.*;

public class EmployeeComparator implements Comparator<Employee> {
	
	public int compare(Employee a,Employee b)
	{
		return a.getName().compareTo(b.getName());
	}
}
