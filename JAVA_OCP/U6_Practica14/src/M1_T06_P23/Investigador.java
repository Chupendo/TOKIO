package M1_T06_P23;

public class Investigador extends PDI{
	//private static final byte IDCATEOGIRA = 3;
	private static byte  HORASSEMANALES = 35;
	private static int PRECIOHORA = 700;
    public Investigador(String nombre, String dni) {
    	super(nombre, dni, HORASSEMANALES, PRECIOHORA);
    }
    
    @Override
    public String toString() {
    	return super.toString()+", categoria= "+CATEGORIA.INVESTIGADORES;
    }


}
