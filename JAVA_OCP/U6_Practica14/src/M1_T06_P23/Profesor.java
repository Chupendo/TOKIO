package M1_T06_P23;

public class Profesor extends PDI{
	
	// �atributos?
	private static final byte IDCATEOGIRA = 2;
	private static byte  HORASSEMANALES = 37;
	private static float PRECIOHORA = 8F;
	
    public Profesor(String nombre, String dni,byte seniosReconocidos) {
    	super(nombre, dni, HORASSEMANALES, PRECIOHORA, seniosReconocidos, IDCATEOGIRA);
       // Rellena el constructor
    }

    // �m�todos?

}
