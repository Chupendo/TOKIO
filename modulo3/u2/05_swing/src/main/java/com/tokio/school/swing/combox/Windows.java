package com.tokio.school.swing.combox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Windows extends JFrame{

	private JButton btOk;
	private JComboBox<?> jcbx;
	private JLabel jlalSelected;
	
	private static Set<Object> colors;
	static {
		colors = new HashSet<>();
		colors.add("Red");
		colors.add("Yellow");
		colors.add("Green");
		colors.add("Blue");
	}
	
	public Windows() {
		// config of windows
		setLayout(new FlowLayout());
		setSize(200, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initComponents();
		
		setVisible(true);
	}
	
	private void initComponents() {
		this.btOk = new JButton("Ok");
		this.btOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jlalSelected.setText((String) jcbx.getSelectedItem());
				
			}
		});
		
		this.jcbx = new JComboBox<Object>(colors.toArray());
		this.jlalSelected = new JLabel();
		
		getContentPane().add(jcbx);
		getContentPane().add(btOk);
		getContentPane().add(jlalSelected);
		
		
		
	}
	
}
