import java.util.Optional;

public class Cuenta {
	protected float saldo;
	protected int numeroIngresos = 0;
	protected int numeroRetiros = 0;
	protected float tasaAnual;
	protected float comisionMensual = 0F;
	
	
	public Cuenta(float saldo, float tasaAnual) {
		this.saldo = saldo;
		this.tasaAnual= tasaAnual;
	}
	
	/**
	 * Incrementa una cantidad de "dinero" al saldo de la cuenta
	 * 
	 * @param float
	 * 		dinero
	 */
	public void ingresarCantidad(float dinero) {
		this.saldo+=dinero;
		this.numeroIngresos++;
	}
	
	/**
	 * Retira una cantiada de "dinero" al saldo de la cuenta
	 * Aumenta el numero retiros de lacuenta y actualiza la comision mensual
	 *
	 * @param float
	 * 		dinero
	 * @return float
	 * 		Saldo de lacuenta actualizao, 0 si no se puede retirar
	 */
	public float retirarDinero(float dinero ) {
		if(dinero<this.saldo) {
			this.saldo=this.saldo-(dinero);
			this.numeroRetiros++;
			calcularComisionMensual();
			return this.saldo;
		}
		return 0F;
	}
	
	/**
	 * Comprueba el numero de retiros y actuliza la comision mensual
	 * Comision mensual se incrementa 1,5€ por cada retiro de dinero una vez superado los 4 retiros
	 */
	private void calcularComisionMensual() {
		if(this.numeroRetiros>4)
			this.comisionMensual = (this.numeroRetiros-4)*1.5F;
		else {
			this.comisionMensual = 0F;
		}
	}
	
	/**
	 * Intereses de la cuenta correinte mensual
	 * Operacion: (saldo*tasaAnual/100 + comision)
	 * return float
	 * 	interes
	 */
	public float calcularInteresMensual() {
		float interes = (this.saldo*this.tasaAnual/100)+this.comisionMensual;
		return interes;
	}
	
	/**
	 * Saldo disponible al finalizar el mes
	 * Operacion: saldo = saldo - (saldo*tasaAnual/100 + comision)
	 * @return float
	 * 		saldo-intres
	 * 
	 * @see #calcularInteresMensual()
	 */
	public float extractoMensual() {
		return this.saldo-calcularInteresMensual();
	}

	/**
	 * Restablce los campos para un nuevo mes
	 */
	public void nuevoMes() {
		this.saldo = this.extractoMensual();
		this.numeroIngresos = 0;
		this.numeroRetiros = 0;
		calcularComisionMensual();
	}
	
	/**
	 * Deuvleve un mensaje con los atribtuos de la clase mas relevantes y los valroe que estos
	 * tiene en la instancia
	 * 
	 * @return String
	 * 		mensaje
	 */
	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + " Eur., numeroIngresos=" + numeroIngresos + ", numeroRetiros=" + numeroRetiros
				+ ", tasaAnual=" + tasaAnual + " %, comisionMensual=" + comisionMensual + " Eur., interes: "+this.calcularInteresMensual()+" Eur.]";
	}
	
	
}
