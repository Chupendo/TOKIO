package codes.exercicies;

/**
 * Tabla de conversión de pulgadas a metro
 *
 * Nota: un metro equivale aproximadamente a 39,37 pulgadas
 * 
 * Nombre del fichero: InToM.java
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class InToM {

	public static void main(String[] args) {
		short N=24,NewLine=12;
		final double In = 39.37, meter; 
		
		for(int i=0;i<=N;i++) {
			System.out.println(i +" in = "+(i*In)+" m.");
			if(i!=0 && i%NewLine==0)
				System.out.println("");
		}
	}
}
