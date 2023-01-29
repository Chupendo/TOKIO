package tokio.clases.inseternas.local;

public class ClaseA {
	public int dato = 9;
	
	public class ClaseB{
		public String nameCB = "Clase interna";
		public ClaseB(){
			
			if(dato<10) {
				
				class Local {
					public void incDato() {
						nameCB+=" 123";
						dato++;
					}
				}
				Local l = new Local();
				l.incDato();
			}
		}
	}
}
