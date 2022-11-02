
public class CuentaBancaria extends Cuenta {
	protected float sobregiro;
	
	public CuentaBancaria(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		this.sobregiro=0F;
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
	@Override
	public void retirarDinero(float dinero) {
		if(this.saldo<=0) {
			this.sobregiro += dinero;
		}else{
			if(dinero>this.saldo) {
				float aux = dinero - this.saldo;
				this.sobregiro += aux;
				super.retirarDinero(dinero-aux);
			}else {
				super.retirarDinero(dinero);
			}	
		}
			
			
	}
	
	/**
	 * Incrementa una cantidad de "dinero" al saldo de la cuenta solo si ésta esta activa
	 * 
	 * @param float
	 * 		dinero
	 * 
	 * @see Cuenta#ingresarCantidad(float)
	 */
	@Override
	public void ingresarCantidad(float dinero) {
		if(this.sobregiro>0) {
			if(this.sobregiro>dinero){
				this.sobregiro = this.sobregiro-dinero;
			}else {
				float aux = dinero - this.sobregiro;
				this.sobregiro = 0;
				super.ingresarCantidad(aux);
			}
		}else {
			super.ingresarCantidad(dinero);
		}
	}
	
	/**
	 * Obitene el extracto mensual de la cuenta contnado el sobregiro
	 * @see CuentaBancaria#calcularInteresMensual()
	 */
	@Override
	public void extractoMensual() {
		super.extractoMensual();
		this.saldo -= this.sobregiro;
		this.sobregiro = 0;
	}
	
	
	/**
	 * Muestra por pantalla una serie de atributos:
	 * <ul>
	 * 	<li>Saldo de la cuenta</li>
	 * 	<li>Comisión mensual</li>
	 *  <li>Transiciones realizas (ingresos+retiros)</li>
	 *  <li>Valor sobregiro</li>
	 * </ul>
	 * @return String
	 * 		mensaje por mantalla
	 */
	public String toString() {
		return "Cuenta de ahorros: [ "+super.toString()+", sobregiro: "+this.sobregiro+"]";
	}

}
