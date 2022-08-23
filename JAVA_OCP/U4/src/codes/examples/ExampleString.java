package codes.examples;

public class ExampleString {

	public static void main(String[] args) {
		String str1 = "Esta es una cadena de ejemplo, en Java en 2022";
		String str2 = new String(str1);
		String str3 = "Java string es potente";
		int result, idx;
		char ch;
		
		System.out.println("Longitud de str1: "+ str1.length());
		
		//mostrar str1, caracter a caracter
		for(int i=0;i<str1.length();i++) {
			System.out.print(str1.charAt(i));
		}
		System.out.println();
		
		//Compara str1 con str2
		if(str1.equals(str2)) {
			System.out.println("str1 igual a str2");
		}else {
			System.out.println("str1 distitno a str2");
		}
		
		// Compara str1 con str3
		if(str1.equals(str3)) {
			System.out.println("str1 igual a str3");
		}else {
			System.out.println("str1 distitno a str3");
		}
		
		
		//
		result = str1.compareTo(str2);
		if(result==0) {
			System.out.println("str1 igual a str2");
		}else if(result < 0)
			System.out.println("str1 es menor que str2");
		else
			System.out.println("str1 es mayor que str2");
		
		result = str1.compareTo(str3);
		if(result==0) {
			System.out.println("str1 igual a str3");
		}else if(result < 0)
			System.out.println("str1 es menor que str3");
		else
			System.out.println("str1 es mayor que str3");
		
		result = str3.compareTo(str1);
		if(result==0) {
			System.out.println("str1 igual a str3");
		}else if(result < 0)
			System.out.println("str3 es menor que str1");
		else
			System.out.println("str3 es mayor que str1");
		
		//asigar una nueva cadena a str2
		str2 = "Uno Dos Tres Uno";
		idx = str2.indexOf("Uno");
		System.out.println("Indes de la primera coincidencia de Uno: "+idx);
		idx = str2.lastIndexOf("Uno");
		System.out.println("Indes de la ultima coincidencia de Uno: "+idx);
		idx = str2.indexOf("Uno", 3);
		System.out.println("Indes de la primera coincidencia de Uno partir de la poscion 4: "+idx);
	}
}
