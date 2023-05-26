package lambda_6;

public class ReferenciaMethodStatic {

	public static void main(String[] args) {
		Persona p1 = new Persona();
		p1.name = "Andres";
		p1.surname = "Ruiz";
		p1.edad = 18;
		
		// Refe a metdo estatico
		MyPredicate<Persona> myLamd1 = Persona::fullName;
		MyPredicate<Integer> myLamd2 = ReferenciaMethodStatic::isMayor;
		
		String resul1 = myLamd1.test(p1);
		System.out.println("Hola "+resul1);
		
		String resul2 = myLamd2.test(p1.edad);
		System.out.println("Edad? "+resul2);
		
		// Ref a un metdo de instancia
		MyIntPredicate myLamd3 = p1::isMayor;
		boolean resul3 = myLamd3.test();
		System.out.println(p1.name+" es mayor?"+resul3);	
	}
	
	public interface MyIntPredicate{
		boolean test();
	}
	
	public interface MyPredicate<T>{
		String test(T p);
	}
	
	public static String isMayor(int n) {
		return (n>=18)?"Es mayor":"Es menor";
	}
}
