package codes.exercicies.tokio.exercicies.four;

public class StringInv {

	public static void main(String[] args) {
		String txt = "Andres";
		
		System.out.println("txt: "+txt);
		System.out.print("txt inv: ");
		showStringInv(txt);

	}
	
	public static void showStringInv(String txt) {
		showStringInv(txt,txt.length()-1);
	}
	public static void showStringInv(String txt,int pos) {
		if(pos>=0) {
			System.out.print(txt.charAt(pos));
			showStringInv(txt,pos-1);
		}
					
	}
}
