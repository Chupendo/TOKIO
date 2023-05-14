package lambda_3;

public class LamdaArgumentDemo {

	public static void main(String[] args) {
		StringFunc reverse = str -> {
			StringBuilder result = new StringBuilder();
			
			for(int i = str.length()-1 ; i>=0; i--) {
				result.append(str.charAt(i));
			}
			
			return result.toString();
		};
		String word = "hola";
		System.out.println("The word is "+word+", is reverse is "+changeStr(reverse, word));
		
	}
	
	public static String changeStr(StringFunc sf, String s) {
		return sf.func(s);
	} 
	public interface StringFunc{
		public String func(String str);
	}
}
