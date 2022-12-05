package exception;

// Ejemplo de regenaricón 
public class ExcDemo12 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };

		for (int i = 0; i <= a.length; i++) {
			try {
				System.out.print(a[i] + "/" + i + "= ");
				System.out.println(a[i] / i);
			} catch (ArithmeticException e) {
			
				e = new MyException();  // regeneracion a NullPointer
				System.out.println("Excepction: " + e);
			}catch(final IndexOutOfBoundsException e) {
				//e = null; // el objeto e es final
				System.out.println("Excepction: " + e);
			}
		}
		System.out.println("End preseed.");
	}
}

// Subclase de ArithmeticExceptions
class MyException extends ArithmeticException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyException() {
		super("My subExcepcion of ArithmeticException");
	}
}
