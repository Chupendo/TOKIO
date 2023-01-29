package tokio.clases.internas.anonimas;

public class ClaseA {
	public String msg ="Hello";
	
	public void getMsg(ClaseAnonima cA) {
		cA.getMsg(this.msg);
	}
}
