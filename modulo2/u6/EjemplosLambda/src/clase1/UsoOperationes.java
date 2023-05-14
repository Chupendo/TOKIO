package clase1;

import java.util.ArrayList;
import java.util.List;

public class UsoOperationes {

	public static void main(String[] args) {
		List<Operaciones> lOpe = new ArrayList<>(); 
		Operaciones<Double> sumInt = (a,b)-> a.intValue()+b.intValue();
		Operaciones<Double> divFloat = (a,b)-> a.doubleValue()/b.doubleValue();
		lOpe.add(sumInt);
		
		System.out.println(sumInt.operacion(12.0, 322.3));
		System.out.println(divFloat.operacion(12.0, 322.3));

		lOpe.add(sumInt);
		lOpe.add(divFloat);
		
		lOpe.forEach(op->{
			System.out.println(op.operacion(12.0, 322.3));
		});
		
	}

}
