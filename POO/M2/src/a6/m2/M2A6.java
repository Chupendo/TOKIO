package a6.m2;

/**
 * Realizamos un programa Java que imprima la tabla de multiplicar del 9 con el siguiente formato: 
 * 
 * 9X1 = 9
 * 9X2 = 18
 * ...
 * 9*X10 = 90
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0 
 *
 */	
public class M2A6 {

	//Numero de elementos a mostrar de la tabla de multiplicar
	public final static short N_ELEMENT = 10;
	//Numero de la tabla de multiplicar
	public final static short ELEMENT = 9;
	
	public static void main(String[] args) {
		
		System.out.println("Tabala de multiplicar del "+ELEMENT+" \"bucle for\"");
		tabla_multiplicar();
		
		//System.out.println("Tabala de multiplicar del "+ELEMENT+" \"recursiva\"");
		//tabla_multiplicar_recursive((short)0);
	}

	/**
	 * Función que calcula la tabla de multiplicar mediante el bucle for
	 * 
	 * @param element:Short
	 */
	public static void tabla_multiplicar() {
		for(int i=0;i<=N_ELEMENT;i++) {
			System.out.println(ELEMENT+" x "+i+" = "+(ELEMENT*i));
		}
	}
	
	/**
	 * Función que calcula la tabla de multiplicar de forma recurisva
	 * 
	 * @param element:Short
	 * @return element:Short
	 */
	/*
	public static short tabla_multiplicar_recursive(short element) {
		System.out.println(ELEMENT+" x "+element+" = "+ELEMENT*element);
		if(element==N_ELEMENT) {
			return 0;
		}else{
			element += (short)1;
			return tabla_multiplicar_recursive(element);
		}
		
	}
	*/
}
