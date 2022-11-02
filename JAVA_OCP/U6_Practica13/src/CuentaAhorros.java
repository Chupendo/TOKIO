import java.util.Optional;

public class CuentaAhorros extends Cuenta {

	private boolean activa;
	
	public CuentaAhorros(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		isActive(); 
	}
	
	/**
	 * Si el sado del acuenta es inferior a 100, la cuenta se desativa
	 * @return boolean
	 * 		true si esta activa, false en otro caso
	 */
	public boolean isActive() {
		//this.activa = this.saldo<100?false:true;
		this.activa = this.saldo>100;
		return this.activa;
	}
	
	/**
	 * Incrementa una cantidad de "dinero" al saldo de la cuenta solo si ésta esta activa
	 * 
	 * @param float
	 * 		dinero
	 */
	public void ingresarCantidad(float saldo) {
		if(this.activa)
			super.ingresarCantidad(saldo);
	}
	
	/**
	 * Retira una cantiada de "dinero" al saldo de la cuenta solo si ésta esta activa
	 * y actualiza si la cuenta esta activa o no
	 *
	 * @param float
	 * 		dinero

	 * @see Cuenta#retirarDinero(float)
	 */
	public void retirarDinero(float saldo) {
		
		if(this.activa)
			super.retirarDinero(saldo);
		
		isActive();	
	}
	
	/**
	 * Obitene el extracto mensual de la cuenta
	 * Comision mensual se incrementa 1,5€ por cada retiro de dinero una vez superado los 4 retiros
	 * 
	 * @see Cuenta#extractoMensual()
	 */
	public void extractoMensual() {
		if(this.numeroRetiros>4) {
			this.comisionMensual = (this.numeroRetiros-4)*1.5F;
		}
		super.extractoMensual();
	}
	
	/**
	 * Muestra por pantalla una serie de atributos:
	 * <ul>
	 * 	<li>Saldo de la cuenta</li>
	 * 	<li>Comisión mensual</li>
	 *  <li>Transiciones realizas (ingresos+retiros)</li>
	 * </ul>
	 * @return String
	 * 		mensaje por mantalla
	 */
	public String Imprimir() {
		return "Cuenta de ahorros: \n"+
				"Saldo de la cuenta: "+this.saldo+
				" Eur., comision mensual: "+this.comisionMensual+
				" Eur., transaciones realizadas: "+(this.numeroIngresos+this.numeroRetiros);
	}
}
