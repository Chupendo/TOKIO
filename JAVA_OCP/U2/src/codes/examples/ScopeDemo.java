package codes.examples;

// Ilustra el �mbito de un bloque
public class ScopeDemo {

	public static void main(String[] args) {
		int x; // conocido para too el c�diog de main
		
		x=10;
		if(x == 10) { // inicio de un nuevo �mbito
			int y = 20; // solo es conocido ara este bloque
			
			// x e y se conocen aqu�
			System.out.println("x and y: "+x+" "+y);
			x= y* 2;
			
		}
		//y = 100; // �Error! y es desconocido aqu�
		
		// x sigue siendo concodio.
		System.out.println("x is "+x);
		
	}

}
