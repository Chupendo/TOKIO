package codes.examples;

public class ExampleStringBuffer {

	public static void main(String[] args) {
		String str = "Java makes the Web move";
		StringBuffer strBuffer= new StringBuffer("Java makes the Web move");
		
		System.out.println("String: "+str);
		System.out.println("String Buffer: "+strBuffer);
		
		str = "Java makes the Web Move";
		strBuffer.setCharAt(19, 'M');
		
		System.out.println("Modificacion de la cadena 1");
		System.out.println("String: "+str);
		System.out.println("String Buffer: "+strBuffer);
	}
}
