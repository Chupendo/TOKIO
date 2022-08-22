package codes.practises.m3.p5;

import codes.practises.m3.p5.Constantes.GOLOSINA;

public class CandyCalculator {
	private int cupones;
	
	/** Consturctores **/
	public CandyCalculator() {
		cupones = 0;
	}
	public CandyCalculator(int cupones) {
		this.cupones = cupones;
	}
	/** Getters and Setters **/
	public int getCupones() {
		return cupones;
	}
	public void setCupones(int cupones) {
		this.cupones = cupones;
	}
	
	/**
	 * metodo que calcula el numero de golosinas que puede cambiar
	 * 
	 * @return resultado
	 * 		Array de int con el numero de GOLOSINA disponibles segun sus cupones
	 */
	public int[] calcularCambio() {
		// declarion de varialbes e inicializacion
		int [] resultado = new int[GOLOSINA.values().length+1]; // desde 0 hasta numero.golosinas
		int temporal = this.cupones;
		GOLOSINA[] key = GOLOSINA.values();

		// numero de golosinas
		int i=0;
		for(i=0;i<GOLOSINA.values().length;i++) {
			// calculamos el numero golosinas segun el numero de cupones 
			// cupones_disponibles/numero_cupones_por_golosina
			resultado[i] = temporal/Constantes.GOLOSINAS.get(key[i]);
			
			// calculamos el resto de cupones
			// cupones_disponibles - (numero_golosinas*numero_cupones_por_golosina)
			temporal = temporal - (resultado[i]*Constantes.GOLOSINAS.get(key[i]));
		}
	
		// cupones sobrantes
		resultado[i] = temporal;
		
		// devuelve el resultado
		return resultado;
	}
	
}
