package com.tokio.schoo.swign.layout.layouts.boxlayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrameBoxLayoutH extends JFrame{

	private JButton btDeleteName;
	private JButton btQuit;
	private JTextField tfName;
	private JPanel panel;
	
	public JFrameBoxLayoutH() {
		initComponents();
		
		pack();
		setLocationRelativeTo(null);
		setVisible(Boolean.TRUE);
		
	}
	
	protected void initComponents() {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		getContentPane().add(panel);
		
		btDeleteName = new JButton("Borrar nombre");
		btDeleteName.addActionListener((ae)->tfName.setText(new String()));
		
		btQuit = new JButton("Salir");
		btQuit.addActionListener((ae)->{
			if(JOptionPane.showConfirmDialog(null, "Esta seguro?","Salir",JOptionPane.YES_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
			System.exit(0);
		});
		
		tfName = new JTextField(50);
		
		panel.add(btDeleteName);
		panel.add(btQuit);
		panel.add(tfName);
		
	}

}
