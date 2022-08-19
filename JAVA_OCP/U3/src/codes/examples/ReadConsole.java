package codes.examples;

import java.io.IOException;

/**
 * Ilsutra una lecutra del teclado
 * 
 * @author Andrés Ruiz Peñuela
 *
 */
public class ReadConsole {

	public static void main(String[] args) throws IOException {
		char data;
		char [] data2 = {0};
		System.out.print("Inserte un digito: ");
		data = (char) System.in.read(); // devuelve el codigo UNICODE del teclado
		
		System.out.println("num is "+data+", codigo unicode: "+(int)data);

	}

}
