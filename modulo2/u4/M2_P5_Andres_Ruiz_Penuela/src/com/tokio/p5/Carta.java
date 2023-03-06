package com.tokio.p5;

public final class Carta {
	private Palo palo;
	private Numero numero;
	
	public Carta(Palo palo, Numero numero) {
		this.palo = palo;
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return this.numero.getAbreviatura()+""+this.palo.getAbreviatura();
	}
	
}
