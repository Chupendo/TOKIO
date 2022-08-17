package listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Listas2 {
	public static void main(String[] args) {
		//Ejemplos para instanciar una lista tipo ArrayList
		List<String> listaNombres = new ArrayList()<>();
		List<Television> listaTelevision = new ArrayList<>();

		//Ejemplos para instanciar una lista tipo LinkedList
		List<String> listaNombres = new LinkedList()<>();
		List<Television> listaTelevision = new LinkedList<>();
		
		//Guaradar un elemento
		listaNombres.add("JORGE");
		String nombre = "LAURA";
		listaNombres.add(nombre);   
		listaNombres.add("RAQUEL");

		listaTelevision.add(new Television("LG",100));
		Television tv = new Television("Sony",35);
		listaTelevision.add(tv);
		
		//Recupearar un elemento
		System.out.println(listaNombres.get(0));
		System.out.println(listaNombres.get(1));
		System.out.println(listaNombres.get(2));

		System.out.println(listaTelevision.get(0));
		System.out.println(listaTelevision.get(1));
	}
}
