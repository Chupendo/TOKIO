package com.tokio.lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tokio.lista.Persona.ESTUDIOS;


public class ListaMain {

	public static void main(String[] args) {
		List<Persona> lPersona = new ArrayList<>();
		
		lPersona.add(new Persona("Andres", 30, ESTUDIOS.UNIVERSIDAD));
		lPersona.add(new Persona("Jorge", 26, ESTUDIOS.FPM));
		lPersona.add(new Persona("Ramon", 28, ESTUDIOS.ESO));
		
		System.out.println("Elementos de la lista: ");
		for (Persona persona : lPersona) {
			System.out.println(persona);
		}
		
		//Ordenacion
		Collections.sort(lPersona);
		
		System.out.println("Elementos ordenado por edad: ");
		for (Persona persona : lPersona) {
			System.out.println(persona);
		}
	}
}
