import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class M1_18_Andres_Ruiz_Penuela {
	private static final Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		byte oper = 0;
		double data = 0.0;
		
		do {
			oper = getByte(IMsg.MENU);
			if(oper==0) {
				System.out.println(IMsg.EXIT);
				break;				
			}
			
			data = getDouble(IMsg.DATA);
			
			try {
				System.out.println(IMsg.RETURN+Operaciones.oper(data, oper));
			} catch (ArithmeticException | IOException e) {
				e.printStackTrace();
			}/*finally { 
				continue;	
			}*/
			System.out.println(IMsg.SPLIT);
			continue;	
			//System.out.println("==============================="); //this never running 
		}while(true);
	}
	
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
	
	public static byte getByte(String msg) {			
		return (byte) getDouble(msg);
	}

}
