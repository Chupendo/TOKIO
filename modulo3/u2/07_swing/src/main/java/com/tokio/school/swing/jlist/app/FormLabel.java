package com.tokio.school.swing.jlist.app;

import java.awt.Font;

import javax.swing.JLabel;

public class FormLabel extends JLabel {

	public FormLabel(String str) {
		super(str);
		this.setFont(new Font("Tahoma", Font.BOLD, 14));
	}

}