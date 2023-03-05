package java.tokio.anotates;

public class RunAnotacion1 {

	public static void main(String[] args) {
		myMeth();

	}
	
	@anotacion1(sqrt = "Anotacion exmaple",val = 100)
	public static void myMeth() {
		System.out.println("hola");
	}

}
