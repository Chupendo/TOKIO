import java.io.IOException;
import java.util.function.DoubleFunction;


public class Operaciones {
	
		/**
		 * Interfaces Funcionales que realizan la operaicon matematica de
		 * logaritmo neperario o natual y la raiz cuadrada de un numero dado
		 * @param Double valor numero decimal con el que se opera
		 * return double valor numero decimal obtenido de la operacion
		 * 
		 * @see Math#log(double)
		 * @see Math#sqrt(double) 
		 */
		private static final DoubleFunction<Double> LN = value -> Math.log(value);
		private static final DoubleFunction<Double> SQRT = value -> Math.sqrt(value);
		
		
		/**
		 * Realiza una operacion determinada ada un valor numero y un indice de operacion
		 * 
		 * @param param
		 * @param oper
		 * @return
		 * @throws ArithmeticException
		 * @throws IOException
		 */
		static double oper(double param,byte oper) throws ArithmeticException, IOException {
			//Comprueba si el valor con el que se opera es menor que 0
			if(param<0) //Si es menor que 0, lanza una excepcion
				throw new ArithmeticException(IMsg.E2);
			
			//Reliaza una operacion dado el indice de operacion
			switch(oper) {
				case 1://Logaritmo neperio o natural
					return LN.apply(param);
				case 2://Raiz cuadrada
					return SQRT.apply(param);
				default://Operaacion no encontrad, lanza un excecion
					throw new IOException(IMsg.E3);
			}
		}
}
