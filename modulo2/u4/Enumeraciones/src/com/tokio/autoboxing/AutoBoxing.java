package com.tokio.autoboxing;

// Autobxing/unboxing dentro de expresiones

public class AutoBoxing {

	public static void main(String[] args) {
		Integer iOb, iOb2;
		int i;
		
		iOb = 99;//auto-boxing
		System.out.println("Orignal value of iOb: "+iOb);
		
		// Lo siguiente extrae automáticamente iOb,
		// realiza el incremento y vuelve a encapsular
		// el resultado en iOb
		++iOb;
		System.out.println("After ++iOb:"+ iOb);
		
		//Aquí, se extrae iOb, su valor se incrementa en 10 y
		//el resultado se encpausa y almacena en iOb;
		iOb += 10;
		System.out.println("After iOb+=10"+ iOb);
		
		//Aquí, se extrae iOb, se evalúa la expresión y
		//el resultado se vuelve a encapsular y se asinga a iOb2
		iOb2 = iOb + (iOb/3);
		System.out.println("iOb2 after expresssion: "+iOb2);
		
		//Se evalua la misma expresión pero el resutlaod
		//no se vuelve a encapsular
		i = iOb + (iOb/3);
		System.out.println("i after expression: "+i);
	}
}
