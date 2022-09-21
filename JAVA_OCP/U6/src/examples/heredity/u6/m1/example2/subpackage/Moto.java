package examples.heredity.u6.m1.example2.subpackage;

import examples.heredity.u6.m1.example2.Example2.*;

/**
 * Continuacion del Example 2.
 * 
 * 
 * La clase Moto hereada de la clase Vehiculo
 * 
 * La clase Moto esta en un paquete diferente,
 * esto ímplica que la clase base sea pública,
 * si fuera protected o package (default) 
 * o private (solo puede declarse private si
 * se trata de una clase dentro de otra clase "inner-class")
 * la clase base, no sería visible.
 * 
 * @author Andrés Ruiz Peñuela
 *
 */
public class Moto extends Vehiculo {
	int chasis;
	public Moto(int ruedas, String modelo, String matricula, int chasis) {
		super(ruedas, modelo, matricula);
		this.chasis = chasis;
	}
	
	
	/** Meotod sobrescrito de la clase base Vehiculo**/
	@Override
	public String toString() {
		// solo puede acceder a los elementos public o protected
		// el atributo "ruedas" no es visible desde otro paquete
		// aunque este pertenezca a la clase base
		/*return "Moto [chasis=" + chasis + ", ruedas=" + ruedas + ", matricula=" + matricula + ", getMatricula()="
				+ getMatricula() + "]";*/ // Da error, ruedas no es visible
		return "Moto [chasis=" + chasis + ", matricula=" + matricula + ", getMatricula()="
		+ getMatricula() + "]";
	}



	public static void main(String[] args) {
		// Coche no es visible desde otra paquete
		// su modificar es package/friendly (default)
		// lo mismo pasa si fuera protected
		//Coche ch = new Coche(4,"Kia","934231A",5);
		
		Moto mt = new Moto(0, "Malva", "341ABC", 12343);
		
		System.out.println(mt.toString());

	}
}
