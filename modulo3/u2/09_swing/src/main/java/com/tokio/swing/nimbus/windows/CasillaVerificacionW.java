package com.tokio.swing.nimbus.windows;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CasillaVerificacionW extends JFrame implements ItemListener{
	JCheckBox jcbox;
	public CasillaVerificacionW() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,200);
		//setResizable(false);
		
		jcbox = new JCheckBox("V");
		
		jcbox.addItemListener(this);
		add(jcbox);
		
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem());
		System.out.println(e.getItemSelectable());
		System.out.println(jcbox.getText()+": "+jcbox.isSelected());
	}
}
