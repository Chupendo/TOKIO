package exception;


// Usar finally
public class ExcDemo9 {
	public static void main(String[] args) {
		for(int i =0;i < 3; i++) {
			UseFinally.genExcetion(i);
			System.out.println();
		}
	}
}

class UseFinally{
	public static void genExcetion(int what) {
		int t;
		int nums[] = new int[2];
		try {
			switch(what) {
			case 0:
				t = 10 / what; //generar errror division por cero
				break;
			case 1:
				nums[4] = 4; //generar error de índice de matriz 
				break;
			case 2: 
				return; // reusltaod de bloque try;
			}
		}catch(ArithmeticException exc){
			System.out.println("Can't divie by Zero!");
			return;
		}catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("No matching element found.");
			return;
		}finally {// se ejeucta al salir del bloques try/catch
			System.out.println("Leaving try.");
		}
	}
}
