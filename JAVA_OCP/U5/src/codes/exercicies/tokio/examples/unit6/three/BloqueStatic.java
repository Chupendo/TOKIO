package codes.exercicies.tokio.examples.unit6.three;

public class BloqueStatic {
	int x;
	static double rootOf2;
	static double rootOf3;

	//Bloque statci: Se lanza antes de crear un objeto
	static {
		System.out.println("Inside static block;");
		//x = 3; // Variable no estatica
		rootOf2 = 3;
		initRootOf3();
	}
	
	private static void initRootOf3() {
		rootOf3 = Math.PI*Math.sqrt(rootOf2);
	}
	
	BloqueStatic(String msg){
		System.out.println(msg);
	}
}
