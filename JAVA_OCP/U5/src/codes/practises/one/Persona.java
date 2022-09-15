package codes.practises.one;

import java.util.Date;

/**
 * Clase que modela una Persona
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0
 * @see Object
 */
public class Persona {
	/** nombre de la persona **/
	private String name; 
	/** apellidos de la persona **/
	private String surName;		
	/** identificación de la persona **/
	private String numberIdentification;	
	/** fecha de cumpleaños de la persona **/
	private Date byrthdate;					

	/**
	 * Constructor para inizalizar los atributos del objeto 
	 * 
	 * @param name
	 * 		Nombre de la persona
	 * @param surName
	 * 		Apellidos de la Persona
	 * @param numberIdentification
	 * 		Identificación de la persona, el método {@link codes.practises.one.Persona#valitNumberIdentification(String) valitNumberIdentification}
	 * 		para comprobar que cumpla el formta, si no lo cumple es null.
	 * @param byrthdate
	 * 		Fecha de cumpleaños de la Persona
	 */
	public Persona(String name, String surName, String numberIdentification, Date byrthdate) {
		this.name = name;
		this.surName = surName;
		this.numberIdentification = valitNumberIdentification(numberIdentification)?numberIdentification:null;
		this.byrthdate = byrthdate;
	}


	/*
	 * Métodos de acceso/modificacion de los atributos del objeto
	 */
	
	/**
	 * Devuelve el nombre de la persona
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sete el nombre de la persona
	 * 
	 * @param name
	 * 		String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve los apellidos la persona
	 * 
	 * @return String
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * Sete los apellidos de la ersona
	 * 
	 * @param surName
	 * 		String
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	/**
	 * Deuvleve la identificación de la persona
	 * 
	 * @return String
	 */
	public String getNumberIdentification() {
		return numberIdentification;
	}

	/**
 	* Setea el identificador del usaurio
 	*  
 	* @param numberIdentification
	*		String, Identificación de la persona, el método {@link Persona#valitNumberIdentification(String) valitNumberIdentification}
	* 		para comprobar que cumpla el formta, si no lo cumple mantiente el valor
	*/
	public void setNumberIdentification(String numberIdentification) {
		this.numberIdentification = valitNumberIdentification(numberIdentification)?numberIdentification:this.numberIdentification;
	}

	/**
	 * Devuelve la fecha de cumpleaños de la persona
	 * 
	 * @return Date
	 */
	public Date getByrthdate() {
		return byrthdate;
	}

	/**
	 * Sete la fecha de cumpleaños de la persona
	 * 
	 * @param byrthdate
	 * 		Date
	 */
	public void setByrthdate(Date byrthdate) {
		this.byrthdate = byrthdate;
	}

	/**
	 * Comprueba que el dni tenga el formato <i>00000000X</i>
	 * 
	 * @param dni
	 * @return boolean
	 * 		true si cumple la condicón, false en caso contrario
	 */
	private static boolean valitNumberIdentification(String dni) {
		return dni.matches("\\d{8}[a-zA-Z]");
	}


	/**
	 * Metodo que deuvelve un mensaje con los valores del objeto
	 * 
	 * @return String
	 * 		Mensaje con los valores del objeto
	 */
	@Override
	public String toString() {
		return "Persona [name=" + name + ", surName=" + surName + ", numberIdentification=" + numberIdentification
				+ ", byrthdate=" + byrthdate + "]";
	}
}
