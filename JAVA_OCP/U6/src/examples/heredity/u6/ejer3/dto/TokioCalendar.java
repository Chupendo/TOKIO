package examples.heredity.u6.ejer3.dto;

import java.security.Provider.Service;

public class TokioCalendar {
	
	private static CalendarService service = new CalendarService();
	public static void main(String[] args) {
		System.out.println("is email: "+service.isEmail("andres.ruiz@gmail.com"));
		System.out.println("is phone: "+service.isPhone("+34653895539"));
		System.out.println("is phone: "+service.isPhone("+653895539"));
		//System.out.println(service.getTypeUser("Inserte el tipo de usuario: "));
		
		Usuario usr1 = service.newUser();
		System.out.println(usr1.toString());
		
		//
		service.addContact(usr1);
		
	}	
}
