package cmcc.gz.restful.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cmcc.gz.restful.domain.Employee;

public class EmployeeDS {
	
	private static Map<Long, Employee> employeeMap;
	
	static {
		employeeMap = new HashMap<Long, Employee>();
		Employee e = new Employee(1L,"张国立","zhangguoli@sina.com");
		employeeMap.put(e.getId(),e);
		
		e = new Employee(2L,"邓超","dengchao@sina.com");
		employeeMap.put(e.getId(),e);
		
		e = new Employee(3L,"郁可唯","yukewei@sina.com");
		employeeMap.put(e.getId(),e);
	}
	
	
	public void add(Employee e){
		employeeMap.put(e.getId(), e);
	}
	
	public Employee get(long id) {
		return employeeMap.get(id);
	}
	
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		for (Iterator<Employee> it = employeeMap.values().iterator(); it.hasNext(); ) {
			employees.add(it.next());
		}
		return employees;
	}
	
	public void update(Employee e) {
		employeeMap.put(e.getId(), e);
	}
	
	public void remove(long id) {
		employeeMap.remove(id);
	}
}
