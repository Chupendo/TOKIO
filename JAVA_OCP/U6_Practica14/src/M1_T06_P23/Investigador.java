package M1_T06_P23;

public class Investigador extends PDI{
	private static final byte IDCATEOGIRA = 3;
	private static byte  HORASSEMANALES = 35;
	private static float PRECIOHORA = 7F;
    public Investigador(String nombre, String dni,byte seniosReconocidos) {
    	super(nombre, dni, HORASSEMANALES, PRECIOHORA, seniosReconocidos, IDCATEOGIRA);
    }

}
