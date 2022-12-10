package M1_T07_P27;

public class M1_16_Andres_Ruiz_Penuela {
	public static CharSequenceTokio charSequenceTokioService;
	public static void main(String[] args) {
		testArrayCharSecuenceTokio();
		//testBackwardsStringCharSequenceTokio();
	}
	
	public static void testArrayCharSecuenceTokio() {
		char [] data = {'a','b','c','d'};
		CharSequenceTokio sub = null;
		charSequenceTokioService = new ArrayCharSequenceTokio(data);
		
		System.out.println("length: "+charSequenceTokioService.length()+".");
		System.out.println("char[9]: "+charSequenceTokioService.charAt(9)+".");
		System.out.println("toString(): "+charSequenceTokioService.toString()+".");
		
		sub = charSequenceTokioService.subSequence(0, 12);
		System.out.println("subSequence(0,12): "+(sub==null?"":sub.toString())+".");
		
		sub = charSequenceTokioService.subSequence(1, 2);
		System.out.println("subSequence(0,42: "+(sub==null?"":sub.toString())+".");
	}
	
	public static void testBackwardsStringCharSequenceTokio() {
		String data = "hola";
		CharSequenceTokio sub = null;
		charSequenceTokioService = new BackwardsStringCharSequenceTokio(data);
		
		System.out.println("length: "+charSequenceTokioService.length());
		//System.out.println("char[9]: "+charSequenceTokioService.charAt(9)+".");
		System.out.println("toString(): "+charSequenceTokioService.toString()+".");
		System.out.println("char[2]: "+charSequenceTokioService.charAt(2)+".");
		System.out.println("toString(): "+charSequenceTokioService.toString()+".");
		
		sub = charSequenceTokioService.subSequence(0, 12);
		System.out.println("subSequence(0,12): "+(sub==null?"":sub.toString())+".");
		
		sub = charSequenceTokioService.subSequence(1, 5);
		System.out.println("subSequence(0,4): "+(sub==null?"":sub.toString())+".");
	}

}
