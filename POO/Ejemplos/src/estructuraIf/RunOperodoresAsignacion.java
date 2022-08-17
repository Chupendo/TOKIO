package estructuraIf;

public class RunOperodoresAsignacion {

	public static void main(String[] args) {
		/**
		 * OPERADORES DE ASIGNAICON
		 * 
		 * Operador |	EjemploWhile en Java |	Expresión equivalente
		 * +=		|	op1+=op2		|	op1=op1+op2
		 * -=		|	op1-=op2		|	op1=op1-op2
		 * *=		|	op1*=op2		|	op1=op1*op2
		 * /=		|	op1/=op2		|	op1=op1/op2
		 * %=		|	op1%=op2		|	op1=op%+op2
		 * ++		|	op1++			|	op1=op1+1
		 * --		|	op1--			|	op1=op1-1
		 */
		
		int numVar=5;
		System.out.println("ESTADO INICIAL: "+numVar);
		numVar+=2;
		System.out.println("numVar+=2: "+numVar);
		numVar-=3;
		System.out.println("numVar-=3: "+numVar);
		numVar*=4;
		System.out.println("numVar*=4: "+numVar);
		numVar/=2;
		System.out.println("numVar/=2: "+numVar);
		numVar%=2;
		System.out.println("numVar%=2: "+numVar);
		numVar++;
		System.out.println("numVar++: "+numVar);
		numVar--;
		System.out.println("numVar--: "+numVar);

	}

}
