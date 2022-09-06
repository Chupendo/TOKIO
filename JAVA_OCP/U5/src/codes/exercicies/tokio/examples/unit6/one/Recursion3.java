package codes.exercicies.tokio.examples.unit6.one;

/**
 * Recorrer un array de forma recursiva.
 * 
 * @author andre
 *
 */
public class Recursion3 {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		
		leer(array,array.length);
	}

	static void leer(int[] array,int n) {
		if(n>0){
			n--;
			System.out.println(array[n]);
			leer(array,n);
		}
	}
}
