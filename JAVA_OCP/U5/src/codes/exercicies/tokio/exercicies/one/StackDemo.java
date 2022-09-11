package codes.exercicies.tokio.exercicies.one;

public class StackDemo {

	public static void main(String[] args) {
		char aux;
		short count = 1;
		Stack sk = new Stack(20);
		
		if(sk.pop()!=0) 
			System.out.println("sk.pop="+sk.pop());
		else
			System.out.println("Sin datos!");
		
		System.out.println("Insert in stakt the chars 3, 4 ,1 and 0");
		sk.push('3'); // First to input
		sk.push('4');
		sk.push('1');
		sk.push('0'); // Last to input
		
		
		do{
			aux= sk.pop();
			if(aux!=0) 
				System.out.println("exit: "+count+ ", sk.pop="+aux);
			else
				System.out.println("Sin datos!");
			count++;
		}while(aux!=0);
	}
}
