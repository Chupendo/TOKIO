package com.tokio.importStatic;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
 /*
  * Progrma que calcula las soluciones
  * de una ecuaicón de segundo grado
  * ax^2 + bx + c = 0;
  */
public class Quadratic {

	public static void main(String[] args) {
		//a, b, c represetna los coeficinetes de la
		//ecuación de segudno grado: ax^2 + bx + c = 0
		double a,b,c,x;
		
		//Resolver 4x^2+ x  3 = 0 para x
		a = 4;
		b = 1;
		c = -1;
		
		// Buscar la priemra solución
		x = (-b + sqrt(pow(b, 2)-4*a*c))/(2*a);
		System.out.println("Firs solution: "+x);
		
		x = (-b - sqrt(pow(b, 2)-4*a*c))/(2*a);
		System.out.println("Firs solution: "+x);
	}
}
