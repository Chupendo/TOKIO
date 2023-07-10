package com.tokio.school.frames;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tokio.school.panel.DataPanel;

public class FrameMain extends JFrame {

	JPanel panel;
	
	public FrameMain() {
		configFrame();
		initComponent();
	
	}
	
	protected void configFrame() {
		setLayout(new FlowLayout());
		setSize(new Dimension(600, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(Boolean.TRUE);
	}
	
	public void initComponent() {
		panel = new DataPanel();
		add(panel);
	}
}
