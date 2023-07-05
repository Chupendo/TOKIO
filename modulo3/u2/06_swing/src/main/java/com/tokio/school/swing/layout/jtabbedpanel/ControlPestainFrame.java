package com.tokio.school.swing.layout.jtabbedpanel;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ControlPestainFrame extends JFrame{
	
	JPanel tabbedPanel;
	public ControlPestainFrame() {
		
		setLayout(new GridLayout(2, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		add(new JLabel("Ejemplo control de pestañas"));
		
		tabbedPanel = new DataPanel();
		add(tabbedPanel);
		
		setVisible(true);
		
		
	}
}
