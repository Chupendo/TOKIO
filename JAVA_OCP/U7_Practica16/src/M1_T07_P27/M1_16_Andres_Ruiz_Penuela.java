package M1_T07_P27;

public class M1_16_Andres_Ruiz_Penuela {
	public static CharSequenceTokio charSequenceTokioService;
	public static void main(String[] args) {
		//testArrayCharSecuenceTokio();
		testBackwardsStringCharSequenceTokio();
	}
	
	public static void testArrayCharSecuenceTokio() {
		char [] data = {'a','b','c','d'};
		charSequenceTokioService = new ArrayCharSequenceTokio(data);
		
		System.out.println("length: "+charSequenceTokioService.length()+".");
		System.out.println("char[9]: "+charSequenceTokioService.charAt(9)+".");
		System.out.println("toString(): "+charSequenceTokioService.toString()+".");
	}
	
	public static void testBackwardsStringCharSequenceTokio() {
		String data = "hola";
		charSequenceTokioService = new BackwardsStringCharSequenceTokio(data);
		
		System.out.println("length: "+charSequenceTokioService.length());
		//System.out.println("char[9]: "+charSequenceTokioService.charAt(9)+".");
		System.out.println("toString(): "+charSequenceTokioService.toString()+".");
		System.out.println("char[9]: "+charSequenceTokioService.charAt(9)+".");
		System.out.println("toString(): "+charSequenceTokioService.toString()+".");
	}

}
