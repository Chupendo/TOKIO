package M1_T06_P25;

public class Main {

	public static void main(String[] args) {
		
		Baraja baraja = new Baraja();
        Mazo mazo = baraja.getMazo();
        System.out.println(mazo.toString());


        System.out.println("OrdPalNumInc");
        mazo.setAlgoritmo(new OrdPalNumInc());
        mazo.ordena();
        System.out.println(mazo.toString());

        System.out.println("OrdPalNumDec");
        mazo.setAlgoritmo(new OrdPalNumDec());
        mazo.ordena();
        System.out.println(mazo.toString());

        System.out.println("OrdNumIncPal");
        mazo.setAlgoritmo(new OrdNumIncPal());
        mazo.ordena();
        System.out.println(mazo.toString());
       
	}

}
