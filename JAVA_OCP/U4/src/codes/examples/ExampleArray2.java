package codes.examples;

public class ExampleArray2 {

	public static void main(String[] args) {
		int [][]matriz = {{2,3},{4,5}};
		short nFilas = (short) matriz.length, count = 0,nColumnas;
		for(int fila[]: matriz) {
			nColumnas = (short) fila.length;
			count=1;
			for(int columna: fila) {
				System.out.print("|"+columna);
				if(nColumnas==count) {
					System.out.print("|");
				}
				count++;
				
			}
			System.out.println();
		}
	}

}
