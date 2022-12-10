package M1_T07_P28;

import java.util.Comparator;

public class ComOrdNumIncPalInc implements Comparator<Carta> {
	@Override
	public int compare(Carta o1, Carta o2) {
		
		if(CartaUtils.transcript(o1.getNumero())<CartaUtils.transcript(o2.getNumero())) {
			return -1;
		}else {
			if(CartaUtils.transcript(o1.getNumero())==CartaUtils.transcript(o2.getNumero()) ) {
				return o1.getPalo().compareToIgnoreCase(o2.getPalo());
			}
			
		}
		return 0;
	}
}
