package tokio.school.m2.p8.run;

import java.util.Random;

import tokio.school.m2.p8.dao.DogDao;
import tokio.school.m2.p8.dto.Dog;

public class Main {

	// Instancia a la clase con las funciones
	public static DogDao dao = new DogDao();

	public static void main(String[] args) {

		System.out.println("Dogs");
		Dog boi = new Dog("boi", 30, 6);
		Dog tyri = new Dog("tyri", 40, 12);
		Dog charis = new Dog("charis", 120, 7);
		
		// Collection all dogs
		Dog[] aDog = {boi,tyri,charis};
		for (Dog dog : aDog) {
			System.out.println("\t-"+dog);
		}
		
		System.out.println("Funciones");
		Dog dogTest = aDog[getIntRandom(aDog.length)];
		
		System.out.println("\t-Test dog= "+dogTest);
		System.out.println("\t-Name= "+dao.getName.apply(dogTest));
		System.out.println("\t-Name Initial= "+dao.getInitial.apply(dogTest.getName()));
		
		// First return the Function that call andThen 
		// and second return the Function called as parameter in andThen
		//In other words, first execute dao.getName and later execute dao.getInitial
		System.out.println("\t-Name.anThen(Initial)= "+dao.getName.andThen(dao.getInitial).apply(dogTest));
		
		// First return the Function called in compose() as parameter 
		// and second return the Function that call compose
		// In other words, first execute dao.getName and later execute dao.getInitial
		System.out.println("\t-Initial.compose(Name)= "+dao.getInitial.compose(dao.getName).apply(dogTest));

	}
	
	public static int getIntRandom(int n) {
		return (new Random()).nextInt(n);
	}
}
