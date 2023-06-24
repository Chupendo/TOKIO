package learning.tokioschool.helloworld;

import java.util.Arrays;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class App {

	public static void main(String[] args) {
		double notas[] = {9.5,10,1.5,6.3,4.5,5,9,8.5};
		
		DescriptiveStatistics estadisticas = new DescriptiveStatistics();
		
		Arrays.stream(notas).forEach(nota->estadisticas.addValue(nota));
		
		System.out.println("El percentil 50 de las notas es: "+estadisticas.getPercentile(50));
		
	}

}
