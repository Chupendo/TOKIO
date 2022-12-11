import java.io.IOException;
import java.util.function.DoubleFunction;


public class Operaciones {
	
		private static final DoubleFunction<Double> LN = value -> Math.log(value);
		private static final DoubleFunction<Double> SQRT = value -> Math.sqrt(value);
		
		static double oper(double param,byte oper) throws ArithmeticException, IOException {
			if(param<0) 
				throw new ArithmeticException(IMsg.E2);
			
			switch(oper) {
				case 1:
					return LN.apply(param);
				case 2:
					return SQRT.apply(param);
				default:
					throw new IOException(IMsg.E3);
			}
		}
}
