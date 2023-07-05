package com.tokio.school.swing.mismath;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MismathFrame extends JFrame{

	protected JPanel panelNorth,panelSouth,panelCenter;
	
	public MismathFrame() {
		configFrame();
		initComponentes();
	}
	
	protected void initComponentes() {
		panelNorth = new NorthPanel();
		
		getContentPane().add(panelNorth,BorderLayout.NORTH);
		getContentPane().add(panelSouth,BorderLayout.SOUTH);
		getContentPane().add(panelCenter,BorderLayout.CENTER);
		
	}
	
	protected void configFrame() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(Boolean.TRUE);
	}
	
	
}
