package java.tokio.anotates;

@Deprecated
public class MyClass {

	private String msg;
		
	public MyClass(String msg) {
		this.msg = msg;
		
	}
	//Renunciar a un método en una clase
	@Deprecated
	String getMsg() {
		return msg;
	}
	
	void setMsg(String msg) {
		this.msg = msg;
	}

}
