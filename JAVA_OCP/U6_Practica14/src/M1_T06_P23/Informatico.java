package M1_T06_P23;

public class Informatico extends PAS{
	
	// �atributos?
	private static final byte IDCATEOGIRA = 0;
	private static byte  HORASSEMANALES = 40;
	private static float PRECIOHORA = 6F;
	
    public Informatico(String nombre, String dni, byte horasExtra) {
    	super(nombre, dni, HORASSEMANALES, horasExtra, HORASSEMANALES,IDCATEOGIRA);
    	// Rellena el constructor
    }
    

}