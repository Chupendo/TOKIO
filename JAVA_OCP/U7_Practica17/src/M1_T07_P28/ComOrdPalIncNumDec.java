package M1_T07_P28;

import java.util.Comparator;

public class ComOrdPalIncNumDec implements Comparator<Carta> {
	@Override
	public int compare(Carta o1, Carta o2) {
		if(o1.getPalo().compareToIgnoreCase(o2.getPalo())<0) {
			return -1;
		}else {
			if(o1.getPalo().compareToIgnoreCase(o2.getPalo())==0) {
				return CartaUtils.transcript(o2.getNumero())-CartaUtils.transcript(o2.getNumero());
			}
		}
		
		return 0;
	}
}
