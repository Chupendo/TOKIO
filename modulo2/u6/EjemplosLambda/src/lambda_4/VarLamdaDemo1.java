package lambda_4;

import java.util.Random;

public class VarLamdaDemo1 {
	static int b = 300;
	
	public static void main(String[] args) {
		int c = 100;
		MyFun myLamda = (a) -> {
			Random rd = new Random();
			double d = rd.nextInt(a) ;
			return (int) ((d*a)+b)/c;
		};
		
		System.out.println("Operacion: "+myLamda.func(13));

	}
	
	public interface MyFun{
		int func(int n);
	}
}
