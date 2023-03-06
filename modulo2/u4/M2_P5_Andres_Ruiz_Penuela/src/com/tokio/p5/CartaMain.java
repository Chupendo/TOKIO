package com.tokio.p5;

import java.util.ArrayList;
import java.util.List;

public class CartaMain {

	public static void main(String[] args) {
		List<Carta> baraja = createBajara();
		
		System.out.println("Size baraja: "+baraja.size());
		baraja.forEach(carta->System.out.print(carta+", "));
	}
	
	public static List<Carta> createBajara(){
		Palo[] palos = Palo.values();
		Numero[] numeros = Numero.values();
		List<Carta> aux = new ArrayList<>();
		
		for (Palo palo : palos) {
			for(Numero numero: numeros) {
				aux.add(new Carta(palo, numero));
			}
		}
		return aux;
	}
}
