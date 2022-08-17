package a6.m3;

import a6.m3.Constantes.ANIMAL;
import a6.m3.Constantes.MATERIAS;
import a6.m3.Constantes.TIPOS_GATOS;
import a6.m3.Constantes.TIPO_NATURALEZA;

public class Run {

	public static void main(String[] args) {
		Naturaleza n1 = new Naturaleza(Constantes.MATERIAS.Agua,Constantes.TIPO_NATURALEZA.HUMANA);
		Naturaleza n2 = new Naturaleza("agua","ramon");
		System.out.println(n1);
		System.out.println(n2);
		
		Animal a1 = new Animal(Constantes.MATERIAS.Tierra, Constantes.TIPO_NATURALEZA.HUMANA, Constantes.ANIMAL.GATO);
		Animal a2 = new Animal(Constantes.MATERIAS.Tierra, Constantes.TIPO_NATURALEZA.MUERTA, Constantes.ANIMAL.GATO);
		a2.peligroExtincion = true;
		System.out.println(a1);
		System.out.println(a2);
		
		//Acceso via Constructor de los atributos de Gato
		System.out.println("Acceso via Constructor de los atributos de Gato:");
		Gato g1 = new Gato(Constantes.MATERIAS.Tierra, Constantes.TIPO_NATURALEZA.HUMANA, Constantes.ANIMAL.GATO, Constantes.TIPOS_GATOS.PERSA);
		Gato g2 = new Gato(Constantes.MATERIAS.Aire, Constantes.TIPO_NATURALEZA.HUMANA, Constantes.ANIMAL.GATO, Constantes.TIPOS_GATOS.PERSA);
		System.out.println(g1);
		System.out.println(g2);
		
		//Acceso unitario a los atributos de GATO 
		System.out.println("Acceso unitario a los atributos de GATO:");
		g2.peligroExtincion = true; 					//Attr protected de ANIMAL
		g2.name="Lady";									//Attr publico de GATO
		g2.setMateria(MATERIAS.Tierra);					//Attr privado de NATURALEZA
		g2.setTipoNaturaleza(TIPO_NATURALEZA.HUMANA);	//Attr privado de NATURALEZA
		g2.setTipoAnimal(ANIMAL.GATO);					//Attr privado de ANIMAL
		g2.setEspecie(TIPOS_GATOS.COMUN_EUROPEO);		//Attr privado de GATO
		System.out.println(g1);
		System.out.println(g2);
	}

}
