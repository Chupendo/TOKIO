package a5.m2;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hacemos un programa Java que calcule el factorial del número que introduzcamos a través del teclado. 
 * 
 * Como restricción, tenemos que comprobar que el número sea menor o igual que 10.
 * Tenemos que tener en cuenta que el factorial de 0 es igual a 1.
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0 
 *
 */
public class M2A5 {
	//Restriccion, el numero debe ser <=LIMIT_TOP
	public static short LIMIT_TOP = 10;
	public static final Logger LOG = Logger.getLogger("M2A5");
	public static void main(String[] args) {
		//Declaracion de variables
		Long resultado = 0L;
		short numero=0;
		Scanner sc = new Scanner(System.in);
		
		
		//Soliitmaos el numero
		do {
			try {
				System.out.print("Inserte un numero entre 0 y "+LIMIT_TOP+": ");
				numero = sc.nextShort();
			}catch(NoSuchElementException | IllegalStateException ex) {
				System.err.println("No es un numero - "+ex);
				sc.nextLine();//Para limpiar el buffer, si no lo pongo me genera un bucle infinito
			}
		}while(numero<0||numero>LIMIT_TOP);

		//Calculamso el factori de un numero
		resultado = fac(numero);
		
		//Mostramos resultado
		System.out.println(numero+"! = "+resultado);
		
		//Mostramos resultado
		//System.out.println(numero+"! = "+facRecursive(numero));
	}
	
	/**
	 * Función que calcula el factorial de un número dado mediante un bucle for
	 * Ejemplo: 5!=5*4*3*2*1*1=120
	 * 
	 * @param numero:Short
	 * @return resultado:Long
	 */
	public static Long fac(short numero) {
		Long resultado = (long) numero;
		if(resultado==0) {
			return 1L;
		}else {
			for(short i=numero;i>1;i--) {
				//LOG.log(Level.INFO, (resultado+"*"+(i-1)));
				resultado = resultado*(i-1);
			}
			return resultado;
		}
	}
	
	 /**
	 * Función que calcula el factorial de un número dado mediante recursivdad
	 * Ejemplo: 5!=5*4*3*2*1*1=120
	 * 
	 * @param numero:Short
	 * @return resultado:Long
	 */
	/*
	public static Long facRecursive(short numero) {
		if(numero==1) {
			return (long)1;
		}else {
			LOG.log(Level.INFO,"numero: "+numero);
			return(long) (numero*facRecursive((short)(numero-1)));
		}
	}
	 */
}
