import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class M1_18_Andres_Ruiz_Penuela {
	// vairalbe para capturar datos por consola
	private static final Scanner SC = new Scanner(System.in);
	
	/**
	 * Metodo principal de la aplicacion
	 * @param args
	 * @see M1_18_Andres_Ruiz_Penuela#getByte(String)
	 * @see #getDouble(String)
	 * @see Operaciones
	 * @see IMsg
	 */
	public static void main(String[] args) {
		// variables
		byte oper = 0;
		double data = 0.0;
		
		do {
			// Solitud de la operacion a realizar
			oper = getByte(IMsg.MENU);
			
			//Control de salida del programa
			if(oper==0) { //Es 0 la operaicon
				System.out.println(IMsg.EXIT);
				break;	//Se sale del programa
			}
			
			// Solitud del parametro del programa
			data = getDouble(IMsg.DATA);
			
			// Ejecucion de la operacion con cotntrol de opciones
			try {
				System.out.println(IMsg.RETURN+Operaciones.oper(data, oper));
			} catch (ArithmeticException | IOException e) {//Caputra de excepcion multiple
				e.printStackTrace();
			}/*finally { //Aseguramos que continue con la ejecuion del bule
				continue;	
			}*/
			System.out.println(IMsg.SPLIT);
			continue;	
			//System.out.println("==============================="); //this never running 
		}while(true);
	}
	
	/**
	 * Captura un double por consola
	 * @param msg cadea de caracteres con el mensaje 
	 * @return valor numerio de tipo double
	 * @see Scanner
	 */
	public static double getDouble(String msg) {
		double opt = 0.0;
		do {
			try {
				System.out.print(msg+": ");
				opt = SC.nextDouble();
				break;
			}catch (InputMismatchException ex) {
				System.err.println(IMsg.E1+ex);
				SC.next(); //clean buffer
				continue;
			}
			
		}while(true);
		
		return opt;
	}
	
	/**
	 * Captura un double por consola
	 * @param msg cadea de caracteres con el mensaje 
	 * @return valor numerio de tipo double
	 * @see M1_18_Andres_Ruiz_Penuela#getDouble(String)
	 */
	public static byte getByte(String msg) {			
		return (byte) getDouble(msg);
	}

}
