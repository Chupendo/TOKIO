package estructuraFor;
/**
 * imprimir la tabla de multiplicar del 9.
 * @author andre
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		System.out.println("Tabla de multiplicar del 9.");
		for(int i=0;i<=10;i++) {
			System.out.println("9x"+i+"= "+(9*i));
			continue; //no hace nada, continua con la ejecución
		}
	}
}
