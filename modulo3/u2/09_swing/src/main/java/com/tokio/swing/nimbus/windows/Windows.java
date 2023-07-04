package com.tokio.swing.nimbus.windows;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Windows  extends JFrame{

	public Windows() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,200);
		setResizable(false);
		
		JLabel jlab = new JLabel("Hello World!");
		add(jlab);
		
		setVisible(true);
		
	}
}
