package com.tokio.schoo.swign.layout.layouts.borderlayout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataPanel extends JPanel {
	private JLabel lbName, lbSurname, lbCategory;
	private JTextField tfName, tfSurname;
	private JComboBox<String> cbCategory;
	
	public DataPanel() {
		setLayout(new GridLayout(3, 2));
		initComponents();
	}
	
	protected void initComponents() {
		
		tfName = new JTextField(10);
		tfSurname = new JTextField(10);
		cbCategory = new JComboBox<String>(new String[]{"categoria 1","categoria 2","categoria 3"});
		lbName = new JLabel("Nombre");
		lbSurname = new JLabel("Apellidos");
		lbCategory = new JLabel("Categoria");
		add(lbName);
		add(tfName);
		add(lbSurname);
		add(tfSurname);
		add(lbCategory);
		add(cbCategory);


	}
}
