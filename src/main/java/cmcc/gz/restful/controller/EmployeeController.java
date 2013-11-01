package cmcc.gz.restful.controller;

import java.io.StringReader;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cmcc.gz.restful.domain.Employee;
import cmcc.gz.restful.domain.EmployeeList;
import cmcc.gz.restful.ds.EmployeeDS;

@Controller
public class EmployeeController {
	
	private EmployeeDS employeeDS;
	
	private Jaxb2Marshaller jaxb2Marshaller;
                     
	private static final String XML_VIEW_NAME = "employees";

	public void setEmployeeDS(EmployeeDS employeeDS) {
		this.employeeDS = employeeDS;
	}
	
	public void setJaxb2Marshaller(Jaxb2Marshaller jaxb2Marshaller) {
		this.jaxb2Marshaller = jaxb2Marshaller;
	}
	
	@RequestMapping(value="/employee/{id}", method = RequestMethod.GET)
	public ModelAndView getEmplpyee(@PathVariable String id) {
		Employee e = employeeDS.get(Long.parseLong(id));
		return new ModelAndView(XML_VIEW_NAME, "employee", e);
	}
	
	@RequestMapping(value="/employee", method = RequestMethod.GET)
	public ModelAndView getEmplpyees() {
		List<Employee> employees = employeeDS.getAll();
		EmployeeList list = new EmployeeList(employees);
		return new ModelAndView(XML_VIEW_NAME, "employees", list);
	}
	
	@RequestMapping(value="/employee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		Employee e = (Employee)jaxb2Marshaller.unmarshal(source);
		employeeDS.add(e);
		return new ModelAndView(XML_VIEW_NAME, "employee", e);
	}
	
	@RequestMapping(value="/employee/{id}", method = RequestMethod.PUT)
	public ModelAndView updateEmployee(@RequestBody String body) {
		System.out.println(body);
		
		Source source = new StreamSource(new StringReader(body));
		Employee e = (Employee)jaxb2Marshaller.unmarshal(source);
		employeeDS.update(e);
		return new ModelAndView(XML_VIEW_NAME, "employee", e);
	}
	
	@RequestMapping(value="/employee/{id}", method = RequestMethod.DELETE)
	public ModelAndView removeEmplpyee(@PathVariable String id) {
		employeeDS.remove(Long.parseLong(id));
		List<Employee> employees = employeeDS.getAll();
		EmployeeList list = new EmployeeList(employees);
		return new ModelAndView(XML_VIEW_NAME, "employees", list);
	}	
}
