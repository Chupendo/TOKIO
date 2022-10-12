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
		this.activa = this.saldo<100?false:true;
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
	 * @return float
	 * 		Saldo de lacuenta actualizao, 0 si no se puede retirar
	 * @see Cuenta#retirarDinero(float)
	 */
	public float retirarDinero(float saldo) {
		float result = 0F;
		if(!this.activa)
			return result;
		
		result = super.retirarDinero(saldo);
		isActive();
		return result;
		
	}
	/**
	 * Obitene el extracto mensual de la cuenta
	 * @see Cuenta#extractoMensual()
	 */
	public float extractoMensual() {
		return super.extractoMensual();
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
