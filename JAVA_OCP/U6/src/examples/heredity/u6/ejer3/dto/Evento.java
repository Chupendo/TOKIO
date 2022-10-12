package examples.heredity.u6.ejer3.dto;

import java.util.Arrays;
import java.util.Date;

public class Evento extends Tarea {
	private static enum NOTIFICATION { EMAIL, SMS, SCREEN;}
	private String place;
	private NOTIFICATION notification;
	private Date effectiveDate;
	private Person[] contac;
	private int nContac;
	
	public Evento(String name, String description, String place, NOTIFICATION notification, Date effectiveDate)	{
		super(name,description);
		this.place = place;
		this.notification = notification;
		this.effectiveDate = effectiveDate;
		this.nContac = 0;
	}
	
	public Evento(Evento event)	{
		this(event.getName(),event.getDescription(),event.getPlace(),event.getNotification(),event.getEffectiveDate());
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public NOTIFICATION getNotification() {
		return notification;
	}
	public void setNotification(NOTIFICATION notification) {
		this.notification = notification;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	public void setContact(Person person) {
		if(isContactEmpaty()) {
			this.nContac++;
			this.contac = new Person[this.nContac];
		}else {
			this.nContac++;
			Arrays.copyOf(this.contac, this.nContac);
		}
		// is a asociation of aggregation
		this.contac[this.nContac] = new Person(person);		
	}
	
	public Person[] getContact() {
		if(this.isContactEmpaty())
			return null;
		return this.contac;
	}
	
	public boolean isContactEmpaty() {
		if(this.nContac==0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Evento [place=" + place + ", notification=" + notification + ", effectiveDate=" + effectiveDate
				+ ", toString()=" + super.toString() + "]";
	}

}
