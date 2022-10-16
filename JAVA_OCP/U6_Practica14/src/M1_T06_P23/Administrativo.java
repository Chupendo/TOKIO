package M1_T06_P23;

public class Administrativo extends PAS{
	
	// �atributos?
	private static final byte IDCATEOGIRA = 1;
	private static byte  HORASSEMANALES = 37;
	private static float PRECIOHORA = 7.5F;
	
    public Administrativo(String nombre, String dni,byte horasExtra) {
    	super(nombre, dni, HORASSEMANALES, PRECIOHORA, horasExtra,IDCATEOGIRA);
    	// Rellena el constructor
    }
    
    // �m�todos?

}
