package codes.exercicies.tokio.activies.three;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JobDemo {

	public static void main(String[] args) {
		List<Job> lJob = new ArrayList<Job>();
		lJob.add(new Job("Andres","Ruiz",2)); // temporal
		lJob.add(new Job("Andres", "Santiago", "26788954F", "ap@gmail.com", getDate(06,07,1992), 1500.6)); // temporal

		System.out.println("Lista de Job");
		lJob.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Incremanta el salario del trabajro Andres Santiaog en 500€");
		lJob.get(1).increSalaryFixed(500); // incre salary 500 €
		lJob.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Incremanta el salario del trabajro Andres Santiaog en 5%");
		lJob.get(1).increSalaryPorcent(5); // incre salary 15%
		lJob.forEach(System.out::println);
		
		
	}
	
	/**
	 * 
	 * @param day
	 * @param moth
	 * 		Numero del mes dado en 1 al 12		
	 * @param year
	 * @return
	 */
	public static Date getDate(int day, int moth, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, moth-1, day);//Se resta una unidad al mes porque va de 0 a 11
		return cal.getTime();
	}

}
