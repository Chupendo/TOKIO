
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
	public float retirarDinero(float dinero) {
		if(dinero>this.saldo) {
			this.sobregiro += (dinero-this.saldo);
			return super.retirarDinero(this.saldo);
		}
		
		return super.retirarDinero(dinero);
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
				this.sobregiro = dinero - this.sobregiro;
				super.ingresarCantidad(dinero-this.sobregiro);
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
	public float extractoMensual() {
		return this.saldo-this.calcularInteresMensual();
	}
	
	/**
	 * Intereses de la cuenta correinte mensual
	 * Operacion: (saldo*tasaAnual/100)
	 * return float
	 * 	interes
	 */
	public float calcularInteresMensual() {
		float interes = ((this.saldo+this.sobregiro)*this.tasaAnual/100);
		return interes;
	}
	
	
	/**
	 * Restablce los campos para un nuevo mes
	 */
	public void nuevoMes() {
		this.saldo = this.extractoMensual()<0?0:this.extractoMensual();
		this.sobregiro = this.extractoMensual()<0?(this.sobregiro-this.extractoMensual()) :0;
		this.numeroIngresos = 0;
		this.numeroRetiros = 0;
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
	public String Imprimir() {
		return "Cuenta de ahorros: \n"+
				"Saldo de la cuenta: "+this.saldo+
				" Eur., comision mensual: "+this.comisionMensual+
				" Eur., transaciones realizadas: "+(this.numeroIngresos+this.numeroRetiros)+
				" , sobregiro: "+this.sobregiro;
	}

}
