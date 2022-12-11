package M1_T08_P30;

public class Member {
	protected String name;
	protected String surnameA;
	protected String surnameB;
	
	public Member(String name, String surnameA, String surnameB) {
		super();
		this.name = name;
		this.surnameA = surnameA;
		this.surnameB = surnameB;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurnameA() {
		return surnameA;
	}
	public void setSurnameA(String surnameA) {
		this.surnameA = surnameA;
	}
	public String getSurnameB() {
		return surnameB;
	}
	public void setSurnameB(String surnameB) {
		this.surnameB = surnameB;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", surnameA=" + surnameA + ", surnameB=" + surnameB + "]";
	}
	
	
	
}
