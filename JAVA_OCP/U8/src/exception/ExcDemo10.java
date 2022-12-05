package exception;

import java.io.IOException;

// Usar de throws
public class ExcDemo10 {
	public static void main(String[] args) {
		char ch;
		
		try {
			ch = UseThrows.prompt("Emter a letter");
			//como prompt() puede generrar la excipon IOException
			// su invocacion debe inlcuriese en un bloque try/catch
			// si se quiere controlar, si no main debe tener
			// thow IOExepction tambien
			// y la MVJ gestionara la excepción
		} catch (IOException e) {
			System.out.println("I/O exception ocurred.");
			ch = 'X';
		}
		System.out.println("You preseed "+ch+".");
	}
}

class UseThrows{
	public static char prompt(String str) throws IOException{ //cláusla trhows
		System.out.print(str + ": ");
		return (char) System.in.read();
	}
}
