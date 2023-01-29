package tokio.clases.internas.anonimas;

public class Main {

	public static void main(String[] args) {
		ClaseA cA = new ClaseA();
		
		cA.getMsg(new ClaseAnonima() {
			@Override
			public void getMsg(String msg) {
				System.out.println(msg+" 1234s");
			}
		} );
	}
}
