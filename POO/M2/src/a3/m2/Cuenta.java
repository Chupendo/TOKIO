package a3.m2;
/**
 * Clase Cuenta
 * @author andre
 * @version 1.0.0
 *
 */
public class Cuenta {
	//Attributs
	private String titular;
	private Long numeroCuenta;
	private Double cantidad;
	
	//Constructors
	public Cuenta() {

	}
	
	public Cuenta(String titular, Long numeroCuenta, Double cantidad) {
		this.titular = titular;
		this.numeroCuenta = numeroCuenta;
		this.cantidad = cantidad;
	}
	
	public Cuenta(Cuenta cuenta) {
		this.titular = cuenta.getTitular();
		this.numeroCuenta = cuenta.getNumeroCuenta();
		this.cantidad = cuenta.getCantidad();
	}
	
	//Getters & Setters
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Long getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	//Method toString() of Object class
	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", numeroCuenta=" + numeroCuenta + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
}
