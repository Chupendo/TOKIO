package codes.examples;

public class Literales {

	public static void main(String[] args) {
		//Literal entero
		int a=10,b=-20;
		long c=10L;
		
		//Literal carácteer
		char d= 'a';
		
		//Literal hexademial, octal y decimal
		int dec = 10;
		int oct = 012;
		int hex = 0xA;
		System.out.println("dec= 10 is in dec "+dec+", oct= 012 is "+oct+" in dec, hex= 0xA is "+hex+" in dec");
		
		//Apartir de JDK 7
		int bin = 0b1010;
		System.out.println("bin= 0b1010 is in dec "+bin);
		
	}

}
