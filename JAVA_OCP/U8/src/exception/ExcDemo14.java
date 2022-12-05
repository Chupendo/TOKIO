package exception;


// Ejemplo de una excepción personalizada
public class ExcDemo14 {
	public static void main(String[] args) {
		int number[] = {4,8,15,32,64,127,256,512 };
		int denom[] = {2,0,4,4,0,8};
		
		// division integer only
		for (int i = 0; i < number.length; i++) {
			try {
				if((number[i]%2) != 0){//evalute number
					throw new NonIntResultException(number[i], denom[i]);
				}
				System.out.println(number[i]+"/"+denom[i]+" is "+number[i]/denom[i]);
			} catch (ArithmeticException e) {
				System.out.println("Can't divide by Zero!");
			} catch(IndexOutOfBoundsException e) {
				System.out.println("Excepction: " + e);
			}catch (NonIntResultException e) {
				System.out.println("Exception "+e+"Stack: ");
				e.printStackTrace();
			}
		}
		System.out.println("End preseed.");
	}
}

// Crear una excepcion
class NonIntResultException extends Exception{
	int n;
	int d;
	public NonIntResultException(int i , int j) {
		n = i;
		d = j;
	}
	
	@Override
	public String toString() {
		return "Result of "+n+" / "+d+" is non-integer.";
	}
}