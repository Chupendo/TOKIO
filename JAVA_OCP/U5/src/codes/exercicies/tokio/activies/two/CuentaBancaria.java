package codes.exercicies.tokio.activies.two;

public class CuentaBancaria {
	private int numCuenta;
	private String titular;
	private double saldo;
	private int interes;
	
	public CuentaBancaria(int numCuenta, String titular) {
		this.numCuenta = numCuenta;
		this.titular = titular;
	}
	public CuentaBancaria(int numCuenta, String titular,double saldo,int interes) {
		this(numCuenta,titular);
		
		this.saldo = saldo;
		this.interes = interes;
	}
	
	public int getNumCuenta() {
		return numCuenta;
	}

	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getInteres() {
		return interes;
	}
	public void setInteres(int interes) {
		this.interes = interes;
	}
	@Override
	public String toString() {
		return "CuentaBancaria [numCuenta=" + numCuenta + ", titular=" + titular + ", saldo=" + saldo + ", interes="
				+ interes + "]";
	}
	
	
	public void ingresar(double coins) {
		if(coins<0) return;
		this.saldo += coins;
	}
	
	public void retirar(double coins) {
		if(coins<0) return;
		this.saldo -= coins;
	}
	
	public double calcularInteresMensual(int numMeses) {
		
		return this.saldo+numMeses*(this.saldo*(this.interes/100.0));
	}
}
