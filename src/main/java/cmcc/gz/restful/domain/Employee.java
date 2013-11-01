package cmcc.gz.restful.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement(name="employee")
@XStreamAlias("employee")
public class Employee {
	
	@XStreamAlias("id")
	private long id;
	
	//@XStreamAlias("ÐÕÃû")
	@XStreamAlias("name")
	private String name;
	
	@XStreamAlias("email")
	private String email;
	
	
	public Employee () {}
	
	public Employee (long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	@XmlElement(name="id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
