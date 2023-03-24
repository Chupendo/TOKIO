package com.tokio.coleciones.listIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.tokio.coleciones.iterable.Persona;
import com.tokio.coleciones.iterable.Persona.ESTUDIOS;

public class IteraionMain {
	public static void main(String[] args) {
		List<Persona> lPerson = new ArrayList<>();

		lPerson.add(new Persona("Andres", 30, ESTUDIOS.UNIVERSIDAD));
		lPerson.add(new Persona("Jorge", 26, ESTUDIOS.FPM));
		lPerson.add(new Persona("Ramon", 28, ESTUDIOS.ESO));

		ListIterator<Persona> iterator = lPerson.listIterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		// Añade donde se quedo el iterador
		iterator.add(new Persona("Pedro", 22, ESTUDIOS.ESO));
		System.out.println("----------------------------");
		while (iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
		//Añade un elmenot en la psicion deuvelte en next o previus y lo incrementea.
		//System.out.println(iterator.previousIndex());
		//iterator.add(new Persona("Pedro", 23, ESTUDIOS.ESO));//añade en la posicion del it y mueve el resto
		//iterator.add(new Persona("Pedro", 24, ESTUDIOS.ESO));//añade en la posicion del it  y mueve el resto
		
		//Remplaza el ultimo elmento retornoado por next o previus, no mueve la posicion del iterador
		System.out.println(iterator.previousIndex());
		iterator.set(new Persona("Pedro", 24, ESTUDIOS.ESO));
		iterator.set(new Persona("Pedro", 23, ESTUDIOS.ESO));// java.lang.IllegalStateException si se añade un elmento
		System.out.println(iterator.previousIndex());
		iterator = lPerson.listIterator();
		System.out.println("----------------------------");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
