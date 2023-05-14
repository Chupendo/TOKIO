package lambda_1;

import java.util.ArrayList;
import java.util.List;

import lambda_1.Persona.GradoAcademico;

public class LamdaWithList {

	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona("ana",57,GradoAcademico.ESO));
		personas.add(new Persona("miguel",51,GradoAcademico.FP));
		personas.add(new Persona("luis",41,GradoAcademico.UNIVERSITARIO));
		personas.add(new Persona("ricardo",34,GradoAcademico.UNIVERSITARIO));
		personas.add(new Persona("esteban",29,GradoAcademico.BACHILLER));
		personas.add(new Persona("laura",21,GradoAcademico.BACHILLER));
		
		// Ordenar por edad de mayor a menor
		System.out.println("Ordenar personas por Edad de <");
		personas.sort((o1,o2)->o1.getEdad()-o2.getEdad());
		personas.forEach(t -> System.out.println(t));
		System.out.println("-------------------------------------");
		
		System.out.println("Ordenar personas por Edad de <");
		personas.sort(Persona::compararEdad);
		personas.forEach(t -> System.out.println(t));
		System.out.println("-------------------------------------");
		
		System.out.println("Ordenar personas por Edad de >");
		personas.sort(LamdaWithList::compararEdadInv);
		personas.forEach(t -> System.out.println(t));
		System.out.println("-------------------------------------");
		
		
		System.out.println("Nombre capital");
		personas.replaceAll(t->{
			t.setNombre(t.getNombre().substring(0,1).toUpperCase()+t.getNombre().substring(1).toLowerCase());
			return t;
		});
		personas.forEach(t -> System.out.println(t));
		System.out.println("-------------------------------------");
		
		System.out.println("Eliminar mayores de 55");
		personas.removeIf(t->t.getEdad()>55);
		personas.forEach(t -> System.out.println(t));
		System.out.println("-------------------------------------");
	}
	
	public static int compararEdadInv(Persona p1, Persona p2) {
		return p2.getEdad()-p1.getEdad();
	}

}
