package codes.exercicies.tokio.examples.unit6.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class VarArgsTest {

	public static void main(String[] args) {
		List<Integer> lEdad1 = Arrays.asList(22,33,21,18,15);
		List<Integer> lEdad2 = Arrays.asList(31,12,15,14);
		
		System.out.print("L1 {");
		lEdad1.forEach(n->System.out.print(" "+n));
		System.out.println(" }");
		System.out.print("L2 {");
		lEdad2.forEach(n->System.out.print(" "+n));
		System.out.println(" }");
	
		lEdad1 = addArray(lEdad1,lEdad2);
		
		System.out.print("L1 + L2 {");
		lEdad1.forEach(n->System.out.print(" "+n));
		System.out.println(" }");
	
	}
	
	/**
	 * Metodo añadae un array dentro de otro
	 * @param ...v
	 * 		List
	 * @return List
	 */
	public static List addArray(List... v) {
		List aux = new ArrayList<>();
		Stream.of(v).forEach(a->{
			a.forEach(b->aux.add(b));			
		});
		return aux;
	}
}
