package examples.heredity.u6.ejer3.dto;

import java.util.Scanner;

import examples.heredity.u6.ejer3.dto.Usuario.TYPE;

public class CalendarService {
	private static final Scanner SC = new Scanner(System.in);
	/**
	 *  El nombre de usuario puede tener caracteres A-Z, caracteres a-z, números del 0 al 9, punto (.), Guión bajo (_)
	 *  >> ^[A-Za-z0-9+_.-]+@(.+)$
	 *  
	 *  Patrón para la validación de correo electrónico está permitido por el método RFC 5322
	 *  >> ^[a-zA-Z0-9_!#$%&'\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$
	 *  
	 *  
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		return email.matches("^[A-Za-z0-9+_.-]+@(.+)$")?true:false;
	}
	
	public static boolean isPhone(String phone) {
		return phone.matches("(\\+34)?\\d{9}")?true:false;
	}
	
	/**
	 * Create new user without event and taks
	 * 
	 * @return Usuario
	 */
	public static Usuario newUser() {
		Usuario usr = null;
		usr = new Usuario(getString("Inserte un nombre: "), getString("Inserte una pwd: "),
				getEmail("Inserte un email: "),getString("Inserte una direccion: "),
				getString("Inserte un telefono: "),getTypeUser("Inserte el tipo de usuario: "));
		return usr;
	}
	
	public static Person newPerson() {
		Person person = null;
		person = new Person(getString("Inserte un nombre: "), getString("Inserte una pwd: "),
				getString("Inserte un email: "),getPone("Inserte un telefono: "));
		return person;
	}
	
	public static String getString(String msg) {
		System.out.print(msg);
		return SC.nextLine();
	}
	
	public static String getEmail(String msg) {
		String email;
		do {
			email = getString(msg);
		}while(!isEmail(email));
		
		return email;
	}
	
	public static String getPone(String msg) {
		String phone;
		do {
			phone = getString(msg);
		}while(!isPhone(phone));
		
		return phone;
	}
	
	public static Usuario.TYPE getTypeUser(String msg) {
		TYPE[] lTypes = getLTypeUser();
		int i;
		
		do {
			System.out.print(msg);
			i = SC.nextInt();
		}while(i<0||i>=lTypes.length);
		
		return lTypes[i];
	}
	
	public static Usuario.TYPE[] getLTypeUser(){
		TYPE[] lTypes = new TYPE[TYPE.values().length];
		int i = 0;
		System.out.println("Tipos de usuario disponilbe");
		for (TYPE type : TYPE.values()) {
			System.out.println(i+". "+type.toString());
			lTypes[i] = type;
			i++;
		}
		return lTypes;
	}
	
	public static void addContact(Usuario user) {
		Evento[] event = user.getEvent();
		if(event==null) {
			System.err.println("Sin eventos");
		}
	}
}
