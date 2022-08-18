package codes.exercicies;
/*
 * Este proyecto, crearemos un programa que muestra la tabla deverdad de los
 * operadores l�gicos de Java. Debe alinear las columans de la tabla. El proyecto
 * aplica algunos de los conceptos analizados en el cap�tulo, como una de las secuencias
 *  de escape y los operadores l�gicos. Tamb�n las diferntes de precedencia entre el operador 
 *  aritm�tico + y los operadores l�gicos.
 */

// Ejercicio 2.2: Tabla de verdad de los oeprdores l�gicos
public class LogicalOpTable {
	public static void main(String[] args) {
		boolean p,q;
		
		
		System.out.println("P\tQ\tAND\tOR\tXOR\tNOT(P)");
		p=true; q=true;
		System.out.print(p+"\t"+q+"\t");
		System.out.print((p&q)+"\t"+(q|q)+"\t");
		System.out.println((p^q)+"\t"+(!p));
		
		p=true; q=false;
		System.out.print(p+"\t"+q+"\t");
		System.out.print((p&q)+"\t"+(q|q)+"\t");
		System.out.println((p^q)+"\t"+(!p));
		
		p=false; q=true;
		System.out.print(p+"\t"+q+"\t");
		System.out.print((p&q)+"\t"+(q|q)+"\t");
		System.out.println((p^q)+"\t"+(!p));
		
		p=false; q=false;
		System.out.print(p+"\t"+q+"\t");
		System.out.print((p&q)+"\t"+(q|q)+"\t");
		System.out.println((p^q)+"\t"+(!p));
		
		//Modificaci�n para que muestre 1 o 0 enlugar de true/false
		System.out.println("P\tQ\tAND\tOR\tXOR\tNOT(P)");
		p=true; q=true;
		System.out.print((p?1:0)+"\t"+(q?1:0)+"\t");
		System.out.print(((p&q)?1:0)+"\t"+((q|q)?1:0)+"\t");
		System.out.println(((p^q)?1:0)+"\t"+((!p)?1:0));
		
		p=true; q=false;
		System.out.print((p?1:0)+"\t"+(q?1:0)+"\t");
		System.out.print(((p&q)?1:0)+"\t"+((q|q)?1:0)+"\t");
		System.out.println(((p^q)?1:0)+"\t"+((!p)?1:0));
		
		p=false; q=true;
		System.out.print((p?1:0)+"\t"+(q?1:0)+"\t");
		System.out.print(((p&q)?1:0)+"\t"+((q|q)?1:0)+"\t");
		System.out.println(((p^q)?1:0)+"\t"+((!p)?1:0));
		
		p=false; q=false;
		System.out.print((p?1:0)+"\t"+(q?1:0)+"\t");
		System.out.print(((p&q)?1:0)+"\t"+((q|q)?1:0)+"\t");
		System.out.println(((p^q)?1:0)+"\t"+((!p)?1:0));
	}

}
