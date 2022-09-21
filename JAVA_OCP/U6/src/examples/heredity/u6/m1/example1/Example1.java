package examples.heredity.u6.m1.example1;
/**
 * Ejemplo 1 de Herencia, explicación de relación entre el clase base y la clase hereditaria
 * 
 * 
 * Relacion: 
 * 
 * Una Moto es un Vehiculo
 * Un Coche es un Vehiculo
 * Vehicuo es un Coche, una Moto
 * 
 * Definicion de herencia:
 * Clase base/superclase:	Vehiculo
 * Clase derivada/subclase: Moto, Coche
 * 
 * @author Andres Ruiz Peñuela
 * @version 1.0
 *
 */
public class Example1 {
	/**
	 * Clase Vehiculo
	 */
	static class Vehiculo{ 
        int  ruedas; 
        Vehiculo(){ } 
        Vehiculo(int ruedas){this.ruedas = ruedas; } 
        
    }
	
	/**
	 * Clase Coche extiende de Vehiculo
	 */
    static class Coche extends Vehiculo { 
        int puertas;
        Coche(){super();}
        
        Coche(int puertas, int ruedas){
         super(ruedas);
         this.puertas = puertas;
        }
    }
    
    /**
	 * Clase Moto extiende de Vehiculo
	 */
    static class Moto extends Vehiculo { 
        boolean casco;
        Moto(boolean casco, int ruedas){
            super(ruedas);
            this.casco = casco;
        }
    }

    /**
     * Relacion entre clase derivada y clase blase
     * @param args
     */
    public static void main(String args[]) {
    	
      // Coche herada los comportamientos de la clase base
      // más sus comportamientos
      Coche cr1 = new Coche (5,4);
      
      // Vehiculo puede ser un coche, una moto y un vehiculo
      Vehiculo vh	= new Vehiculo(4);
      Vehiculo vh1	= new Coche(5,4);	// vehiculo es un coche
      Vehiculo vh2	= new Moto(true,2);	// vehiculo es una moto
      
      // Pero una clase derivada no puede ser una clase
      // vehiculonto, porque vehiculo puede ser vehiculo, coche o moto
      // Coche cr2 = (Coche) vh;  // Por tanto, esto no se puede dar
      
      // Sin embargo, un objecto de clase derivada
      // puede gardar la referencia de un objeto de la clase base
      // siempre y cuando sean del mismo tipo
      // (poliformimos)
      Coche cr3 = (Coche) vh1;  //cr3 tiene la referencia de vh1 que es un coche
      //System.out.println("vh1.puertas: "+vh1.puertas); //atributo desconodio
      System.out.println("vh1.ruedas: "+vh1.ruedas);
      System.out.println("cr3.puertas: "+cr3.puertas);
      System.out.println("cr3.ruedas: "+cr3.ruedas);
      
    }
}
