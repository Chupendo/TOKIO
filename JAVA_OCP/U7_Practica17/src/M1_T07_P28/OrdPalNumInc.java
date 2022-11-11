package M1_T07_P28;

import java.util.Comparator;
import java.util.List;

public class OrdPalNumInc extends AlgoritmoOrdenacion {

	/**
	 * Metodo que ordernad por palo en orde natural (menor a mayor alfanumericamente) y por numero de carta
	 * decreciente (de ayor a menor
	 * 
	 * @param listaCartas:List<Carta>
	 * 		Lista de cartas a ordernadar
	 */
	@Override
	public void ordena(List listaCartas) {
		// Algoritmos de1 ordenacion
		int resultado=0;

		//Ordenamos por palo
		int nCartas = listaCartas.size();
		for(int z=0;z<=1;z++) {
			for(int i=0;i<nCartas;i++) {
				for(int j=0;j<nCartas;j++) {
					if(listaCartas.get(i) instanceof Carta && listaCartas.get(j) instanceof Carta) {
							Carta c1 = (Carta)listaCartas.get(i);
							Carta c2 = (Carta)listaCartas.get(j);
							resultado = comparadorCarta(c1,c2);
							
							//System.out.println("c1= "+c1.toString()+", c2= "+c2.toString()+", resultado= "+resultado);
							if(resultado==-1&&z==0) {
								//System.out.println("swap for palo");	
								swap(listaCartas,c1, c2, i, j);
								
							}else {
								if(resultado==-2&&z==1) {
									//System.out.println("swa for numero");						
									swap(listaCartas,c1, c2, i, j);
								}
							}
					}
				}
			}
		}
	}

	
	
	/**
	 * Metodo que compara dos cartas {c1,c2} y devuelve:
	 * <ul>
	 * <li>-2: si el palo de c1 es menor que el palo de c2</li>
	 * <li>-1: si el numero de c1 es mayor que el numero de c2</li>
	 * <li>0: resto de los casos</li>
	 * </ul>
	 *  
	 * , 
	 * @param c1:Carta
	 * @param c2:Carta
	 * 
	 * @return int
	 * 		Resutlado de compara el atributo "palo" y "numero" de ambas cartas
	 */
	public static int comparadorCarta(Carta c1, Carta c2) {
		// Comparador de cartas usado en el algoritmo de ordenaci�n
		//Comparacion por Palo alfanumerico orden natural +  Numero de mayor a menor
		//Code -1 :: c1.palo > c2.palo || Code -2: c1.numero < c2.numero   	-- Intercambiar  
		//Explicación de la comparacion de String:
		
		// El codigo ASCII https://www.javatpoint.com/java-ascii-table
		// Si str1.comparteTo(str2)>0 entonces str1 es menor que str2 (por el CODIGO ASCII)
		// Si str1.comparteTo(str2)<0 entonces str1 es mayor que str2 (por el CODIGO ASCII)
		// Si str1.comparteTo(str2)==0 entonces str1 es igual que str2 (por el CODIGO ASCII)
		// Ejemplo: str1= A (65), str2= B (66)  "A".comparteTo("B")=-1 -- "A" es menor que "B"
		
		//Code -0 resto de casos
		//System.out.println("comp OrdPalNumDec");
		/*
		System.out.println("c1.getPalo()= "+c1.getPalo()
				+", c1.getPalo().substring(0,1)= "+c1.getPalo().substring(0,1)
				+", c2.getPalo()="+c2.getPalo()
				+", c2.getPalo().substring(0,1)="+c2.getPalo().substring(0,1)
				+", c1.getPalo().substring(0,1).compareTo(c1.getPalo().substring(0,1)) = "+c1.getPalo().substring(0,1).compareTo(c2.getPalo().substring(0,1)));*/
		if((ordenarPalo(c1.getPalo().substring(0,1), c2.getPalo().substring(0,1)))<0) {
			//El palo de c1 es mayor que el palo c2 => Intercambiamos
			return -1;
		}else {
			if(((ordenarPalo(c1.getPalo().substring(0,1), c2.getPalo().substring(0,1)))==0) && ( ordenarNumInc(Carta.transcript(c1.getNumero()), Carta.transcript(c2.getNumero()))<0)) {
				//El numero de c1 es menor que el c2 => Intercambiamos
				return -2;
			}
		}
		// Resto de casos
		return 0;
	}

}
