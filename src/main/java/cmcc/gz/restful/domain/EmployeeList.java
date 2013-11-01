package cmcc.gz.restful.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name="employees")
@XStreamAlias("employees")
public class EmployeeList {

	private int count;
	
	@XStreamAlias("rows")
	private List<Employee> employees;
	
	public EmployeeList() {}
	
	public EmployeeList(List<Employee> list) {
		this.count = list.size();
		this.employees = list;
	}
	
	@XmlElement(name="count")
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name="employee")
	public List<Employee> getEmployeeList() {
		return employees;
	}

	public void setEmployeeList(List<Employee> employees) {
		this.employees = employees;
	}
}
