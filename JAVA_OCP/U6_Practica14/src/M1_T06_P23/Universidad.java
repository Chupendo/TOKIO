package M1_T06_P23;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Universidad {

	public static void imprimirNominas(Personal[] listaPersonal) {
		Stream.of(listaPersonal).forEach(personal -> {
			if(personal!=null) {
				if (personal instanceof PAS) {
					System.out.println(personal.toString() + ", nomina: " + ((PAS) personal).calcularSueldoSinReset()+" Euros");
				} else {
					System.out.println(personal.toString() + ", nomina: " + ((PDI) personal).calcularSueldo()+" Euros");
				}
			}

		});
	}

	public static long obtenerPresupuestoTotal(Personal[] listaPersonal) {
		Predicate<Personal> p1 = (Personal person) -> person != null;
		// Opcion A: MEDINATE FILTOS PARA OBTERNES POR SEPARADOS LOS SALARIOS EN FUNDIÓN SI ES PAS O PDI
		/*
		Predicate<Personal> p2 = (Personal person) -> person instanceof PAS;
		Predicate<Personal> p3 = (Personal person) -> person instanceof PDI;
		
	
		// Restablece las horas estras
		Float salariosPAS = Stream.of(listaPersonal).filter(p1.and(p2)).map(person -> (person).calcularSueldo())
				.reduce((pres, nomina) -> {
					return pres + nomina;
				}).orElse(0F);

		Float slariosPDI = Stream.of(listaPersonal).filter(p1.and(p3)).map(person -> ((PDI) person).calcularSueldo())
				.reduce((pres, nomina) -> {
					return pres + nomina;
				}).orElse(0F);

		return (long) Math.round(salariosPAS+slariosPDI);
		*/
		
		// Opcion B: OBTIENETE TODOS LOS SARLIROS
		Float salariosUNI = Stream.of(listaPersonal).filter(p1).map(person -> person.calcularSueldo())
				.reduce((pres, nomina) -> {
					return pres + nomina;
				}).orElse(0F);
		return (long) Math.round(salariosUNI);

	
	}

}
