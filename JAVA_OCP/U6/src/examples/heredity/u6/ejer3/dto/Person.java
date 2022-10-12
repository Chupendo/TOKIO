package examples.heredity.u6.ejer3.dto;

public class Person {
	private static Long cont;
	private Long id;
	private String name;
	private String pwd;
	private String email;
	private String phone1;
	static{
		cont = 1L;
	}

	public Person() {}
	public Person(String name, String pwd, String email, String phone1) {
		this.id = cont;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.phone1 = phone1;
		this.cont++;
	}
	
	public Person(Person person) {
		this(person.getName(),person.getPwd(), person.getEmail(),person.getPhone1());	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", phone1=" + phone1 + "]";
	}
}
