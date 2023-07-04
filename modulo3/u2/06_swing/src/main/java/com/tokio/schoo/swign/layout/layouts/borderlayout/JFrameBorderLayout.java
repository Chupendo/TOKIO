package com.tokio.schoo.swign.layout.layouts.borderlayout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrameBorderLayout extends JFrame {

	private JButton button1, button2, button3, button4;
	private JPanel buttonsPanel, centralPanel, statusPanel;
	private JLabel lbStatus;
	
	public JFrameBorderLayout() {
		initComponents();
		configuerJFrame();
	}

	protected void configuerJFrame() {
		pack();
		setLocationRelativeTo(null);
		setVisible(Boolean.TRUE);
	}

	protected void initComponents() {
		setLayout(new BorderLayout());

		// Panales
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());

		centralPanel = new DataPanel();
		

		statusPanel = new JPanel();
		statusPanel.setLayout(new FlowLayout());

		// Añade los paanles a la ventana
		getContentPane().add(buttonsPanel, BorderLayout.NORTH);
		getContentPane().add(statusPanel, BorderLayout.SOUTH);
		getContentPane().add(centralPanel, BorderLayout.CENTER);

		// Botones superiores
		button1 = new JButton("Botón 1");
		button2 = new JButton("Botón 2");
		button3 = new JButton("Botón 3");
		button4 = new JButton("Botón 4");
		buttonsPanel.add(button1);
		buttonsPanel.add(button2);
		buttonsPanel.add(button3);
		buttonsPanel.add(button4);

		// Zona central

		// Barra de estado
		lbStatus = new JLabel("Barra de estado");
		statusPanel.add(lbStatus);

	}
}
