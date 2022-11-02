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
	 * Aumenta el numero retiros de la cuenta
	 * si procede
	 *
	 * @param float
	 * 		dinero
	 * @return float
	 * 		Saldo de lacuenta actualizao, 0 si no se puede retirar
	 */
	public void retirarDinero(float dinero ) {
		if(dinero<=this.saldo) {
			this.saldo=this.saldo-(dinero);
			this.numeroRetiros++;
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
	 * 	 * Actualiza el saldo restándole la comisión mensual y calculando el interés mensual correspondiente
	 * 
	 * Operacion: saldo = saldo - (saldo*tasaAnual/100 + comision)
	 * 
	 * @see #calcularInteresMensual()
	 */
	public void extractoMensual() {
		
		this.saldo = this.saldo - this.comisionMensual - calcularInteresMensual();
		
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
				+ ", tasaAnual=" + tasaAnual + " %, comisionMensual=" + comisionMensual + " Eur.]";
	}
	
	
}
