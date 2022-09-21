package examples.heredity.u6.m1.example3;

import java.util.Scanner;

public class Trabajador extends Persona { //Trabajador2 hereda de Persona2

    private String cargo;
    
    public Trabajador() {
        super();
        System.out.println("Constructor del Trabajador2");
    }
    public String getCargo() {//Getter
        return cargo;
    }
    public void setCargo(String cargo) {//Setter
        this.cargo = cargo;
    }
    

    // No puede definirse este metodo porque existe
    // en la clae base y esta declarado como 
    // final
    /*
    public void leer() {
    	Scanner entrada = new Scanner(System.in);
        System.out.println("DNI: ");
        setNif(entrada.nextLine());
        System.out.println("Nombre: ");
        setNombre( entrada.nextLine());
    }
    */
    
    @Override //Con esto indicamos que el método se sobrescribe
    public void leer(String dni, String nombre) {
        Scanner entrada = new Scanner(System.in);
        super.leer(dni,nombre); //Se llama al método leer de Persona2
        System.out.println("Cargo: ");
        cargo = entrada.nextLine();
    }
	@Override
	public String toString() {
		return "Trabajador [cargo=" + cargo + ", toString()=" + super.toString() + "]";
	}
}