package codes.practises.three;

import java.util.stream.Stream;

public class M1_12_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		Bag lBag1 = new Bag();
		System.out.println("Bag vacia? "+lBag1.isEmpty());
		System.out.println(lBag1.toString());
		
		lBag1.add("hola");
		System.out.println(lBag1.toString());
		
		lBag1.add(1);
		System.out.println(lBag1.toString());
		
		System.out.print("Extract a number with same propability of the list: ");
		System.out.println(lBag1.extract());
		
		System.out.println("Size of list: "+lBag1.size());
		
		System.out.println("Search the element 1 in the list: "+lBag1.contains(1));
		System.out.println("Search the element 2 in the list: "+lBag1.contains(2));
		
		System.out.println("---------------------------------------");
		lBag1.clear();
		System.out.println("Clear the list: "+lBag1.size());
		System.out.println("Bag vacia? "+lBag1.isEmpty());
		System.out.print("Extract a number with same propability of the list: ");
		System.out.println(lBag1.extract());
		
		lBag1.add(2);
		System.out.println(lBag1.toString());
		System.out.print("Extract a number with same propability of the list: ");
		System.out.println(lBag1.extract());
	}
	
	

}
