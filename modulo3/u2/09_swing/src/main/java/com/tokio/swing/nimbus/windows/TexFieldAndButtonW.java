package com.tokio.swing.nimbus.windows;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TexFieldAndButtonW extends JFrame{

	public TexFieldAndButtonW() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,200);
		//setResizable(false);
		
		JTextField jTxtF = new JTextField("Hello World!", 32);
		JButton jbtn = new JButton("Read");
		jTxtF.addActionListener((ae)->{
		
			System.out.println(ae.getActionCommand());
		});
		jbtn.addActionListener((ae)->{
			
			System.out.println(ae.getActionCommand());
		});
		add(jbtn);
		add(jTxtF);
		
		setVisible(true);
	}
	
}
