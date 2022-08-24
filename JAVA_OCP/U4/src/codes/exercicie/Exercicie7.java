package codes.exercicie;

public class Exercicie7 {

	public static void main(String[] args) {
		String key="12345678", text="abcdefghabcdefgh", encode,decode, temp1 ;
		StringBuilder temp2 = new StringBuilder();
		
		System.out.println("Testo plano: "+text);
		
		if(text.length()%key.length()!=0) {
			System.err.println("Longitud del texto invalida");
			return; 
		}
		
		// Codificicion
		for(int i=0;i<text.length();i=i+key.length()) {
			temp1 = text.substring(i,i+key.length());
			for(int j=0;j<key.length();j++)
				temp2.append((char) (text.charAt(j)^key.charAt(j)));
		}
		encode = temp2.toString();
		temp2 = new StringBuilder();
		System.out.println("Texto encodificado: "+encode);
		
		// Decodificacion
		for(int i=0;i<encode.length();i=i+key.length()) {
			temp1 = encode.substring(i,i+key.length());
			for(int j=0;j<key.length();j++)
				temp2.append((char) (encode.charAt(j)^key.charAt(j)));
		}
		decode = temp2.toString();
		temp2 = new StringBuilder();
		System.out.println("Texto decodificado: "+decode);
	}
}
