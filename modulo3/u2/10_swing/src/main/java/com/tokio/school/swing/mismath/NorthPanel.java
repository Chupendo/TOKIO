package com.tokio.school.swing.mismath;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NorthPanel extends JPanel{
	
	protected JLabel jlb;
	
	public NorthPanel() {
		confingPanel();
		initComponent();
	}
	
	public void initComponent() {
		jlb = new JLabel("Mismath");
	}
	public void confingPanel() {
		setLayout(new FlowLayout());
	}

}
