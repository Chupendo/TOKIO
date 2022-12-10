package M1_T07_P28;

import java.util.Comparator;

public class ComOrdNumDecPalDec implements Comparator<Carta> {
	@Override
	public int compare(Carta o1, Carta o2) {
		
		if(CartaUtils.transcript(o2.getNumero())<CartaUtils.transcript(o1.getNumero())) {
			return -1;
		}else {
			if(CartaUtils.transcript(o1.getNumero())==CartaUtils.transcript(o2.getNumero()) ) {
				return o2.getPalo().compareToIgnoreCase(o1.getPalo());
			}
			
		}
		return 0;
	}
}
