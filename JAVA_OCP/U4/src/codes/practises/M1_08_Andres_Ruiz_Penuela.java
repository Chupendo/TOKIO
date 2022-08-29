package codes.practises;

import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		short[] arrayDePrueba = new short[1];//= {1, 2, 3, 3, 9, 8, 7, 4, 6, 7, 0, 4, 5, 3};
		short duplicados[]  = new short[1], temporal[]= new short[1], count=0, numero;
		String temp;
		boolean agregar = false;
		
		//Solicitamos los numeros
		
		do {
			System.out.print("Inserte un nunemro (. para salir): ");
			temp = sc.nextLine();
			if(temp.equals("."))
				break;
			try {
				numero = Short.parseShort(temp);
				
				if(temporal==null){//No es la primera iteracion
					temporal = arrayDePrueba.clone();
					arrayDePrueba = new short[temporal.length+1];
					for(short elemento :temporal) {
						arrayDePrueba[count]=elemento;
						count++;
					}
				}else {
					arrayDePrueba = new short[1];
				}
					
				// Volcamos el dato en el array
				arrayDePrueba[count] = numero;
				
				// Resetemaos
				numero = 0;
				temporal = null;
				count = 0;
				
			}catch(Exception ex) {
				System.err.println("No es un numero: "+ex);
			}
		}while(true);
		
		// Resetemaos
		numero = 0;
		temporal = null;
		count = 0;
		// Mostramos el vector
		System.out.print("Vector: { ");
		for(short elem : arrayDePrueba) {
			System.out.print(elem+" ");
		}
		System.out.println("}");
		
		
		// Buscamos repetidos
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
		if(count==0)
			System.out.println("No hay elementos repetidos");
		else {
			System.out.print("Repetido/s: { ");
			for(short elem : duplicados) {
				if(elem!=-1)
				System.out.print(elem+" ");
			}
			System.out.println("}");
		}
	}
}
