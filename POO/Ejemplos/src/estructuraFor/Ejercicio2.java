package estructuraFor;
/**
 * calcular la suma de los números pares comprendidos entre 1 y 20.
 * @author andre
 *
 */
public class Ejercicio2 {

	//Mi solución
	public static void main(String[] args) {
		int result=0; //summ of pair numbers
		for(int i=1;i<=20;i++) {
			if(i%2==0) {
				result+=i;
			}
		}
		System.out.print("Sume de los nuemros pares comprendidos entre 1 y 20: "+result);

	}

	//Solucion de tokio school
	/*
	public static void main(String[] args) {

        int suma=0;
        for(int i=2; i<20; i=i+2) {

            suma += i;
            // suma += i equivale a suma = suma + i

            System.out.println("Total = "+suma);
        }
    }
    */
}
