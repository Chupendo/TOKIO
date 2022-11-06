package M1_T06_P23;

public class Informatico extends PAS{
	//private static final byte IDCATEOGIRA = 0;
	private static byte  HORASSEMANALES = 40;
	private static int PRECIOHORA = 600;
	
    public Informatico(String nombre, String dni, byte horasExtra) {
    	super(nombre, dni, HORASSEMANALES, PRECIOHORA, horasExtra,CATEGORIA.INFORMATICO/*IDCATEOGIRA*/);
    }
    

}
