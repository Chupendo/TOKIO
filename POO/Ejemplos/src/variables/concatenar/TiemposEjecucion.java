package variables.concatenar;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class TiemposEjecucion {

	public static void main(String[] args) {

		int i = 0;
        String resultado = "";
        StringBuilder resultado2 = new StringBuilder("");
        //Concatenacion mediante ".concat()"
        long time = System.currentTimeMillis();
        final long N = Long.parseLong(args[0]);
        while(i<N) {
        	resultado.concat(Long.toString(i));
        	i++;
        }
        time= System.currentTimeMillis()-time;
        System.out.println("Tiempo de ejecución de N= "+N+" repetiiciones mediante .concat()= "+time+" ms");

        
        //Concatenacion mediante "+"
        i=0;
        time = System.currentTimeMillis();
        while(i<N) {
        	resultado=resultado + i;
        	i++;
        }
        time= System.currentTimeMillis()-time;
        System.out.println("Tiempo de ejecución de N= "+N+" repetiiciones mediante += "+time+" ms");
        
      //Concatenacion mediante StringBulder
        i=0;
        time = System.currentTimeMillis();
        while(i<N) {
        	resultado2.append(i);
        	i++;
        }
        time= System.currentTimeMillis()-time;
        System.out.println("Tiempo de ejecución de N= "+N+" repetiiciones mediante StringBulder= "+time+" ms");

	}

}
