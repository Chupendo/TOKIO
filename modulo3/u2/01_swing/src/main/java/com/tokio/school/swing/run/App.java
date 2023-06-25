/**
 * Ejemplo sencillo de un programa Swing
 */
package com.tokio.school.swing.run;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.tokio.school.swing.texts.Constans;

public class App {

	/**
	 * Crea un Objecto Swing al crea un objeto de tipo App.
	 */
	App(){
		// 1. Creacion y configuraicón de la Ventana
		// 1.1 Crea un nuevo contedro pesado de tipo JFrame
		JFrame jfrm = new JFrame(Constans.APP_TITLE);
		
		// 1.2 Asinga un tamaño de la ventaa
		jfrm.setSize(Constans.APP_WIDTH, Constans.APP_LENGTH);
		
		// 1.3. Determina cuando cerrar el programa
		// Terminar el prograga al cerrar la aplicacion.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		
		// 2.  Creacion de un componete
		// 2.1 Crea una etiqueta (componente pasivo)
		JLabel jlab = new JLabel(Constans.APP_LABEL_MSG_WELCOMEN);
		
		// 2.2 Añadri el componente a la ventana
		jfrm.add(jlab);
		
		// 3. Mostrar el Marco
		jfrm.setVisible(true);
	}
	public static void main(String[] args) {
		// Crea un objeto Swing en una interfaz Runnable dentro
		// del subproceso de entregador de evnetos
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// Objecto Swing
				new App();				
			}
		});		
	}
}
