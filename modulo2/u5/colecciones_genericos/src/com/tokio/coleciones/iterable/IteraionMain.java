package com.tokio.coleciones.iterable;


import static com.tokio.coleciones.iterable.Persona.ESTUDIOS;

public class IteraionMain {
	public static void main(String[] args) {
		Persona[] mPerson = {new Persona("Andres", 30, ESTUDIOS.UNIVERSIDAD),
				new Persona("Jorge", 26, ESTUDIOS.FPM),
				new Persona("Ramon", 28, ESTUDIOS.ESO)};
		
		IteracionPersona itPersona = new IteracionPersona(mPerson);
		
		for (Persona persona : itPersona) {
			System.out.println(persona);
		}
	}
}
