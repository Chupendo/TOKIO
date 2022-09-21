package examples.heredity.u6.m1.example3;

import java.util.Scanner;

public class Persona {

    //Atributos de la clase persona
    private String dni;
    private String nombre;
        
    public String getNif() {//Getter
        return dni;
    }
    public void setNif(String nif) {//Setter
        this.dni = nif;
    }
    public String getNombre() {//Getter
        return nombre;
    }
    public void setNombre(String nombre) {//Setter
        this.nombre = nombre;
    }
    public final void leer() {//Método para leer
        Scanner entrada = new Scanner(System.in);
        System.out.println("DNI: ");
        dni = entrada.nextLine();
        System.out.println("Nombre: ");
        nombre = entrada.nextLine();
    }
    
    public void leer(String dni, String nombre) {//Método para leer
        this.dni = dni;
        this.nombre = nombre;
    }
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
	}
}