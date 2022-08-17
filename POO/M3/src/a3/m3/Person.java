package a3.m3;

public class Person {

	private String name;
	private String surNames;
	private int age;
	
	/**Constructors**/
	public Person(String name, String surNames, int age) {
		super();
		this.name = name;
		this.surNames = surNames;
		this.age = age;
	}

	/**Getters and Setters**/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurNames() {
		return surNames;
	}

	public void setSurNames(String surNames) {
		this.surNames = surNames;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/** Methods Publics **/
	//Ejmeplo de poliformismo de sobrecarga: Sobreescrbie el método toString del Padre (Clase Padre: Object)
	@Override
	public String toString() {
		return "Person [name=" + name + ", surNames=" + surNames + ", age=" + age + "]";
	}
	
}
