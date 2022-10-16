package M1_T06_P23;

public class Profesor extends PDI{
	
	// Constantes de clase
	private static final byte IDCATEOGIRA = 2;
	private static final byte  HORASSEMANALES = 37;
	private static final float PRECIOHORA = 8F;
	
    public Profesor(String nombre, String dni,byte seniosReconocidos) {
    	super(nombre, dni, HORASSEMANALES, PRECIOHORA, seniosReconocidos, IDCATEOGIRA);
    }

}
