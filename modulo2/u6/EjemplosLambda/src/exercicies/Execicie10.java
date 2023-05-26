package exercicies;

public class Execicie10 {

	public static void main(String[] args) {
		StringUtils changeStr = (text)->{
			
			// Elimina espacios, tabuladores, retornos
			return text.replaceAll("\\s","");
		};
		
		System.out.println("changeStr(Hola mundo !) = "
		+changeStr.func("Hola mundo !"));
	}
	
	public interface StringUtils{
		String func(String str);
	}

}
