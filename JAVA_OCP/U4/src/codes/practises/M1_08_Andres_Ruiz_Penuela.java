package codes.practises;
/**
 * Crear un programa que, dado un array de números enteros, determine cuales 
 * son sus elementos que se encuentran duplicados.
 * Por ejemplo:
 * 	int[] arrayDePrueba= {1, 2, 3, 3, 9, 8, 7, 4, 6, 7, 0, 4, 5};
 * 
 * @author Andres Ruiz Penuela
 *
 */
public class M1_08_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		int[] arrayDePrueba= {1, 2, 3, 3, 9, 8, 7, 4, 6, 7, 0, 4, 5, 3};
		short[] duplicados = new short[1], temporal= new short[1];
		short count=0;
		boolean agregar = false;
		
		
		for(int i=0;i<arrayDePrueba.length;i++) {
			for(int j=i+1;j<arrayDePrueba.length;j++) {
				
				if(arrayDePrueba[i]== arrayDePrueba[j] ) {// Es un repetido
					// Comprobamos si ya se detecto como repetido
					for(int x=0;x<duplicados.length;x++) {
						if(duplicados[x]!=arrayDePrueba[j]) {// Repetido nuevo
							agregar = true;
						}else {// Repetido ya detectado
							agregar = false;
						}
					}
					
					// El nuevo es un nuevo reptiedo
					if(agregar) {
						// Redimensionamos para meter el nuevo repetido
						temporal = new short[count+1];
						
						// Volcamos datos para guardar los viejos repetidos
						for(int x=0;x<duplicados.length;x++) {
							if(duplicados[x]!=arrayDePrueba[j]) {
								temporal[x] = duplicados[x];
							}
						}
						// Agreganos el nuevo reptido
						temporal[count]=(short)arrayDePrueba[j];
						duplicados = new short[temporal.length];
						
						// Salvamos los repetidos detectados hasta ahora
						duplicados = temporal.clone();
						
						// Reseteamos valores
						temporal = null;
						agregar = false;
						count++;
						break;
					}
				}
			}
		}

		// Mostramos resultados
		System.out.print("Repetido/s: { ");
		for(short elem : duplicados) {
			if(elem!=-1)
			System.out.print(elem+" ");
		}
		System.out.println("}");
	}
}
