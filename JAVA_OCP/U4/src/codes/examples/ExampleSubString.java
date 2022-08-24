package codes.examples;

public class ExampleSubString {

	public static void main(String[] args) {
		String orgstr = "Java makes the Web move.";
		
		// crear una subcadena
		String substr = orgstr.substring(5, 18);
		
		System.out.println("orgstr: "+orgstr);
		System.out.println("substr: "+substr);
	}
}
