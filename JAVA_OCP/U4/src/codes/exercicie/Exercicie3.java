package codes.exercicie;

public class Exercicie3 {

	public static void main(String[] args) {
		double array[] = new double[10];
		double sum = 0.0;
		
		for(int i=0;i<array.length;i++) {
			array[i] = (Math.random()*10)+1;
		}
		
		for(double elem : array) {
			sum += elem;
			System.out.print(elem+" ");
		}
		System.out.println();
		System.out.println("Media: "+sum/array.length);
	}
}
