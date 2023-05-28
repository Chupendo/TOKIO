package com.tokio.p8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {

	public static void main(String[] args) {
		
			Pattern regla = Pattern.compile("[A-Z]");
			Matcher validador = regla.matcher("Ca");
			
			if(validador.matches()) {
				System.out.println("Si");
			}else {
				System.out.println("No");
			}
			
			// Uso del metodo String.matches(PatternToString) de String
			String str = "C";
			System.out.println(str.matches(regla.toString()));
			
			
			//
			usoBasckslash();
			
			usoAcentoCircuflejo();
			
			usoDolar();
			
			usoClasesCaracteres();
			
			usoClasesCaracteresAbreviados();
			
			agrupaciones();
			
			
			System.out.println("Varios");
			System.out.println("AaA.mathces('a-z'):"+"AaA".matches("(a-z)"));
	}
	public static final String LoremInpusm="Lorem ipsum dolor sit amet, consectetur adipiscing elit.-Nullam imperdiet fermentum aliquam. In vehicula orci vel lacus scelerisque pulvinar. Curabitur lacus lectus, lacinia sit amet erat ac, tincidunt vestibulum diam. In molestie id leo non porta. Curabitur egestas, lectus in malesuada bibendum, urna ipsum luctus ante, in hendrerit turpis ante et justo. Nullam tristique risus sem, porta euismod ligula aliquet vitae. Phasellus pellentesque, nibh eu tempus euismod, mi ex pretium lacus, maximus tristique massa orci sit amet lectus. Aenean iaculis leo in dignissim consequat. Sed feugiat magna risus, ut luctus lectus porttitor ut. Sed commodo sit amet ipsum sed imperdiet. Aliquam et risus sit amet nisi porta volutpat. Curabitur non arcu dictum, euismod sapien non, mattis neque.";
	
	
	public static void  usoBasckslash() {
		// Termina en .-
		System.out.println("Termina '*.': "+"Lorem.".matches(".*\\."));
		
		// Termina en .-
		System.out.println("Termina '*.-': "+LoremInpusm.matches(".*[\\.-]"));
		
		// Contiente en *.*
		System.out.println("Termina '*..*': "+"Lor.me".matches(".*\\..*"));
		
	}
	
	// Anclajes
	public static void  usoAcentoCircuflejo() {
		// Empìeza por Lor*
		System.out.println("Empieza 'Lor*': "+LoremInpusm.matches("^Lor.*"));
		
		// Empìeza por ipsum
		System.out.println("Empieza 'ipsum': "+LoremInpusm.matches("^ipsum*"));	
	}
	
	public static void  usoDolar() {
		// Termina por por .*em$
		System.out.println("Termina por por .*em$': "+LoremInpusm.matches(".*em$"));
		
		// Termian por .*neque\\.$
		System.out.println("Termian por .*neque.$: "+LoremInpusm.matches(".*neque\\.$"));	
	}
	
	
	public static void usoClasesCaracteres() {
		System.out.println("usoClasesCaracteres");
		System.out.println("'a'.matches('\\p{Digit}'): "+"a".matches("\\p{Digit}"));
		System.out.println("'aa'.matches('\\p{Digit}'): "+"aa".matches("\\p{Digit}"));
		System.out.println("'1a'.matches('\\p{Digit}'): "+"1a".matches("\\p{Digit}"));
		System.out.println("'1a'.matches('^[\\p{Digit}].*'): "+"1a".matches("^[\\p{Digit}].*"));
	}
	
	public static void usoClasesCaracteresAbreviados() {
		System.out.println("usoClasesCaracteresAbreviados");
		System.out.println("'a'.matches('\\d'): "+"a".matches("\\d"));
		System.out.println("'aa'.matches('\\d'): "+"aa".matches("\\d"));
		System.out.println("'1a'.matches('\\d'): "+"1a".matches("\\d"));
		System.out.println("'1a'.matches('^[\\d].*'): "+"1a".matches("^[\\d].*"));
	}
	
	public static void agrupaciones() {
		System.out.println("AGRUPACIONES");
		System.out.println("'a1'.matches('(^[\\w][\\D]]$'): "+"a1".matches("(^[\\w][\\D]$)"));
		System.out.println("'aA'.matches('(^[\\w][\\D]]$'): "+"aA".matches("(^[\\w][\\D]$)"));
	}
}
