package com.tokio.swing.nimbus.windows;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TexFieldW extends JFrame{

	public TexFieldW() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,200);
		//setResizable(false);
		
		JTextField jTxtF = new JTextField("Hello World!", 32);
		add(jTxtF);
		
		
		
		setVisible(true);
	}
	
	
}
