package examples.heredity.u6.ejer3.dto;

import java.util.Arrays;

public class Tarea {
	private String name;
	private String description;
	private Person[] contac;
	private int nContac;
	
	public Tarea(String name,String description) {
		this.name = name;
		this.description = description;
		this.nContac = 0;
	}

	public Tarea(Tarea taks) {
		this(taks.getName(),taks.getDescription());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Person[] getContact() {
		return contacEmpaty()?null:this.contac;
	}
	
	public void setContat(Person person) {
		if(!contacEmpaty()) {
			this.nContac++;
			contac= new Person[this.nContac];
		}else {
			this.nContac++;
		}
		this.contac = Arrays.copyOf(this.contac, this.nContac);
		this.contac[this.nContac] = person;
	}

	private boolean contacEmpaty(){
		return this.nContac==0?true:false;
	}
	
	@Override
	public String toString() {
		if(this.contacEmpaty())
			return "Tarea [name=" + name + ", description=" + description + "contac =[ empaty ]]"
					;
		return "Tarea [name=" + name + ", description=" + description + "contac =["+Arrays.asList(this.contac).toString()+"]]";
	}
	
}
