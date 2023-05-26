package tokio.school.m2.p9.run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.tokio.m2.p9.dataCiudades.CiudadDao;

import tokio.school.m2.p9.dto.Ciudad;

public class Main {

	public static final CiudadDao dao = new CiudadDao();
	public static void main(String[] args) {
				
		List<Ciudad> lCidudades = new ArrayList<>();
		lCidudades = dao.createLCiudades(100);
		
		lCidudades.forEach(System.out::println);
		
		// Realiza las operaciones con Streams que permitan contestar a las preguntas
		
		// Pregunta 1. ¿Cuántas ciudades hay en total?
		System.out.println("Numero de ciduades: "+
				lCidudades.stream().map(Ciudad::getCiudad).distinct().count());
		
		// Pregunta 2. ¿Cuántas ciudades de "Madrid" tienen más de 1.000 habitantes?
		Predicate<Ciudad> isMadrid = (c)->c.getCiudad().equals("Madrid");
		Predicate<Ciudad> isMayorNPeopole = (c)->c.getHabitantes()>1000;
		System.out.println("Numero de ciudades de Madrid con mas de 1000 habitantes: "+
				lCidudades.stream().filter(isMadrid.and(isMayorNPeopole)).count());
		
		// Pregunta 3.¿De que provincias son las ciudades?
		System.out.println("Provincias y sus Ciudades de la Lista:");
		lCidudades.forEach(c-> System.out.println("\t- "+c.getProvincia()+" es de "+c.getCiudad()));
		
		// Pregunta 4. ¿De cuantas provincias diferentes son las ciudades?
		Map<String, Integer> mNumProvCity = new HashMap<String, Integer>();
		
		List<String> lProvincias = lCidudades.stream().map(Ciudad::getProvincia).distinct().collect(Collectors.toList());	
		Map<String,Integer> numProvinciasDiferentesEnCiudades = new HashMap<>();
		
		lCidudades.stream().forEach(c->{
			int i = 0;
			if(lProvincias.contains(c.getProvincia())) {
				if(numProvinciasDiferentesEnCiudades.containsKey(c.getCiudad())) {
					i = numProvinciasDiferentesEnCiudades.get(c.getCiudad())+1;
				}
				numProvinciasDiferentesEnCiudades.put(c.getCiudad(), i);
				lProvincias.removeIf(p -> p.equals(c.getProvincia()));
			}
		});
		System.out.println("Numero de poblaciones diferentes en cada ciudad: ");
		numProvinciasDiferentesEnCiudades.forEach((k,v)->{System.out.println("\t-"+k+": "+v);});
	
		// Pregunta 5. ¿Alguna ciudad de Madrid tiene más de 50.000 habitantes?
		Long count;
		Integer num = 50000;
		BiPredicate<Ciudad,Integer> nHabitantes = (ciudad,nPoblacion)-> ciudad.getHabitantes()>nPoblacion;
		count=lCidudades.stream().map(c->{
			if(nHabitantes.test(c, num)) {
				return Optional.ofNullable(c);
			}
			return Optional.ofNullable(null);
		}).filter(Optional::isPresent).map(opC->(Ciudad)opC.get()).filter( isMadrid).count();
		System.out.println("Poblaciones de madrid con mas de "+num+" habitantes: "+count);
	}
}
