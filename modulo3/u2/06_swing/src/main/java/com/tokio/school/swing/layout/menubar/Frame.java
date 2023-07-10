package com.tokio.school.swing.layout.menubar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	JPanel panelNorth;
	
	public Frame() {
		configure();
		initComponent();
	} 
	
	protected void configure() {
		setLayout(new BorderLayout());
		setSize(300,300);
		setVisible(Boolean.TRUE);
	}
	
	public void initComponent() {
		panelNorth = new JPanel();
		panelNorth.add(new MenuBar());
		getContentPane().add(panelNorth, BorderLayout.NORTH);
	}
}
