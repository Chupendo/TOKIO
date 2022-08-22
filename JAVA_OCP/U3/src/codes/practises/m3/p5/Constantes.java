package codes.practises.m3.p5;

import java.util.HashMap;
import java.util.Map;

public class Constantes {
	public static enum GOLOSINA {Caramelo,Chicle};
	public static final Map<GOLOSINA, Integer> GOLOSINAS = new HashMap<>();
	static {
		GOLOSINAS.put(GOLOSINA.Caramelo,10);
		GOLOSINAS.put(GOLOSINA.Chicle, 3);
	}
}
