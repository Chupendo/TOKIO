package codes.exercicies;

import java.io.IOException;

public class Excercicie10 {

	public static void main(String[] args) throws IOException {
		StringBuilder texto = new StringBuilder();
		char ch;
		System.out.print("Inserte caracteres (. para finalizar). ");
		do {
			ch = (char) System.in.read();
			if(ch=='.') {
				texto.append(ch);
				break;
			}else {
				if(ch>=97&&ch<=122)
					ch-=32;
				else if(ch>=65&&ch<=90)
					ch+=32;
			}
			texto.append(ch);
		}while(true);
		
		System.out.println(texto);
	}

}
