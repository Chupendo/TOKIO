package estructuraFor;
/**
 * Imprimir de modo decreciente los números impares comprendidos entre 15 y 0.
 * @author andre
 *
 */
public class Ejercicio3 {
	//Mi solución
	public static void main(String[] args) {
		for(int i=15;i>=0;i--) {
			if(!(i%2==0)) {
				System.out.println(i+" es un número impar");
			}
		}
	}
	
	//Socluión Tokio School	
	/*
	 public static void main(String[] args) {

        for(int i=15; i>=0; i-=2) {

            // i = i-=2 equivale a i=i-2

            System.out.println("valor de i = "+i);

        }
    }
	 */
}
