package M1_T06_P23;

public class Administrativo extends PAS{
	//private static final byte IDCATEOGIRA = 1;
	private static byte  HORASSEMANALES = 37;
	private static int PRECIOHORA = 750;
	
    public Administrativo(String nombre, String dni,byte horasExtra) {
    	super(nombre, dni, HORASSEMANALES, PRECIOHORA, horasExtra);
    }
    
    @Override
    public String toString() {
    	return super.toString()+", categoria= "+CATEGORIA.ADMINISTRATIVO;
    }

}
