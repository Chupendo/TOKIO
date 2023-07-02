package com.tokio.school.swing.jlist.app;


import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListW extends JFrame {


	JList<String> jList;
	JLabel jlab;
	JScrollPane jscrip;
	ListSelectionListener controlador; 
    
	// Crea una matiz de nombres, para el JList
	String [] names = new String[]{"Sherry","Jhon","Racher","Sasha","Josselyn","Randy","Tom","Mary","Ken","Adrew", "Matt", "Todd"};
	
	public JListW() {
		// contenedor
		super("JList Demo");
		
		// ESPECIFICA UN DISEÑO DE FLUJO
		setLayout(new FlowLayout());
		setSize(200,160);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		// termina el programa cuando el usuairo cierra la app
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// Crea un Jlist
		jList = new JList<String>(names);
		
		//modo de selecicon
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// añade la lista al panel desplazable
		jscrip = new JScrollPane(jList);
		
		// tamaño del panel
		jscrip.setPreferredSize(new Dimension(120,90));
		
		// crea una etiqueta que mueste el texto seleccionado
		jlab = new FormLabel("Plase choose na name");
		
		// añade un controlador de selecicon de lista
		controlador = (e)-> event(e); 
		jList.addListSelectionListener(controlador);
		
		// añadri los componentes
		this.add(jscrip);
		this.add(jlab);
		
		// mostrar la ventana
		this.setVisible(true);
	}	
	
	private void event(ListSelectionEvent e) {
		// obtener el idnice
		int idx = jList.getSelectedIndex();
		
		// mostar la selecion
		if(idx!=-1) {
			jlab.setText("Current selection: "+names[idx]);
		}else {
			jlab.setText("Please choose a name");
		}
	}
}
