package codes.exercicie;

public class Exercicie4 {

	public static void main(String[] args) {
		String str[] = {"Hola", "1","ramon","Pedro"};
		String temp;
		
		System.out.print("Cadena desordenada: ");
		for(String text : str) {
			System.out.print(text+" ");
		}
		System.out.println();
		
		// Metodo de la burbuja para ordenar
		for(int i=0;i<str.length;i++) {
			for(int j=1;j<(str.length-1);j++) {
				if(str[i].compareTo(str[j])>0) {
					 temp = str[j];
					 str[j]=str[i];
					 str[i] = temp;
				}					
			}
		}
		
		System.out.print("Cadena ordenada: ");
		for(String text : str) {
			System.out.print(text+" ");
		}
		System.out.println();
		
	}
}
