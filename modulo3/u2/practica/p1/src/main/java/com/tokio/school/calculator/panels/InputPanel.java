package com.tokio.school.calculator.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tokio.school.calculator.frames.CalculatorFrame;

import lombok.Getter;
import lombok.Setter;

public class InputPanel extends PanelAbstract {
	@Getter protected JTextField txtField;
	@Getter JLabel lbl;
	private static final String TXT_PACHELOADER = "Inserte a numbers";
	private static final short N_COLUMS = CalculatorFrame.HEIGHT_FRMAE/10;
	
	public InputPanel() {
		confingPanel();
		initComponents();
	}

	@Override
	void confingPanel() {
		setLayout(new FlowLayout());		
	}

	@Override
	void initComponents() {
		lbl = new JLabel("0");
		add(lbl);
		txtField = new JTextField(TXT_PACHELOADER, N_COLUMS);
		txtField.setEditable(Boolean.FALSE);
		txtField.setPreferredSize(new Dimension(N_COLUMS,25));
		add(txtField);
	}
}
