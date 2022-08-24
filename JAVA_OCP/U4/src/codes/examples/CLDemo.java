package codes.examples;

public class CLDemo {

	public static void main(String[] args) {
		System.out.println("Tere are "+args.length+" command-line arguments.");
		
		System.out.println("They are: ");
		short i=0;
		for(String arg : args) {
			System.out.println("arg["+i+"]: "+args[i]);
		}
	}
}
