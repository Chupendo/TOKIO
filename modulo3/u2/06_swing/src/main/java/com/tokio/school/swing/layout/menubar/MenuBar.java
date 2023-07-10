package com.tokio.school.swing.layout.menubar;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{

	public MenuBar() {
		// menu Fichero>Abrir,Salir
		JMenu menuFile = new JMenu("Fichero");
		
		JMenuItem menuItemOpen = new JMenuItem("Abrir");
		menuFile.add(menuItemOpen);
		
		JMenuItem menuItemQuit = new JMenuItem("Salir");
		menuFile.add(menuItemQuit);
		add(menuFile);
		add(menuFile);
		
		// menu Editar>
		JMenu menuEdit = new JMenu("Editar");
		add(menuEdit);
		
		// menu Herramientas>
		JMenu menuTools = new JMenu("Herramientas");
		add(menuTools);

		// menu Ayuda>
		JMenu menuHelp = new JMenu("Ayuda");
		add(menuHelp);
	}
}
