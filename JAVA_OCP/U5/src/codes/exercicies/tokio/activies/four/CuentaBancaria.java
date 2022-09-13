package codes.exercicies.tokio.activies.four;

public class CuentaBancaria {
	private double balance;
	private String numberCount;
	private float tax;
	private String mainPerson;
	private String entity;
	
	
	public CuentaBancaria(double balance, String numberCount, float tax, String mainPerson, String entity) {
		this.setBalance(balance);
		this.balance = this.getBalance();
		this.numberCount = numberCount;
		this.tax = tax;
		this.mainPerson = mainPerson;
		this.entity = entity;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		if(balance<0)
			throw new RuntimeException("El salario debe ser mayor o igual que cero");
		
		this.balance = balance;
	}
	
	public String getNumberCount() {
		return numberCount;
	}
	public void setNumberCount(String numberCount) {
		this.numberCount = numberCount;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public String getMainPerson() {
		return mainPerson;
	}
	public void setMainPerson(String mainPerson) {
		this.mainPerson = mainPerson;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [salary=" + balance + ", numberCount=" + numberCount + ", tax=" + tax + ", mainPerson="
				+ mainPerson + ", entity=" + entity + "]";
	}
	
	/**
	 * Ingresa una cantidad mayor o igual que el sado de la cuenta
	 * @param ingress
	 * @exception RutimeException
	 */
	public void ingresing(double ingress) {
		if(ingress<this.balance) 
			throw new RuntimeException("La cantidad a ingresar debe ser mayor o igual que el saldo de la cuenta");
		
		this.balance += ingress;
	}
}
