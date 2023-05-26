package lambda_6;

import java.util.stream.Stream;

public class RefenciaConstructor {

	public static void main(String[] args) {
		MyFunc genPersona = Persona::new;
		
		Persona p = genPersona.func("andres", "ruiz",  3);
		System.out.println(p.toString());
		
		MyFuncGen<String> myStr = String::new;
		System.out.println("myStre: "+myStr.func());
		
		IGenarteArray<Persona> mcArray = Persona[]::new;
 		Persona[] aP =  mcArray.func(3);
 		for(int i=0;i<aP.length;i++) {
 			aP[i] = new Persona("Andres "+i,"Ruiz",3);
 		}
 		
 		Stream.of(aP).forEach(System.out::println);
 
	}

	interface MyFunc{
		// MyFunc es una interfaz funcional
		// cuyo metodo devuelve una referencia
		// a Persona
		Persona func(String n, String s, int e);
	}
	
	interface IGenarteArray<T>{
		// MyFunc es una interfaz funcional
		// cuyo metodo devuelve una referencia
		// a un array d T
		T[] func(int n);
	}
	
	interface MyFuncGen<T>{
		// MyFunc es una interfaz funcional
		// cuyo metodo devuelve una referencia
		// a T
		T func();
	}
}
