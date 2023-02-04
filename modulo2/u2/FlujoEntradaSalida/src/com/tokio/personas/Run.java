package com.tokio.personas;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Run {

	public static void main(String[] args) {
		//To LocalDate to Date
		LocalDate dateLD = LocalDate.of(1992, Month.JULY, 6);
		Date date = Date.from(dateLD.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		//
		Person p = new Person("Andres", 30, date, "2649965R");
		
		try {
			//Flujo E/S bytes
			PersonService.saved(p); //Saved person as csv
			PersonService.saved2(p); //Saved person as SerializationUtils
			PersonService.saved3(p); //Saved person as ObjetOutputStrem
			
			//Flujo E/S caracteres + NIO2
			List<String> info = new ArrayList<>();
			info.add("Hoal Mundo");
			info.add("Que tal");
			info.add("Buenos días");
			PersonService.saved4(info);
			
			//Flujo E/S caractres + NIO2
			PersonService.read();
			//Fluejo E/S bytes
			PersonService.read2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
