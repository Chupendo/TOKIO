package com.tokio.school.calculator.frames;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.tokio.school.calculator.panels.MainPanel;

public class CalculatorFrame extends CalculatorFrameAbstract {
	public static final short WIDTH_FRAME = 300;
	public static final short HEIGHT_FRMAE  = 200;
	MainPanel mainPanel;
	
	public CalculatorFrame() {
		confingFrame();
		initComponents();
		setVisible(Boolean.TRUE);
	}

	@Override
	void confingFrame() {
		setSize(new Dimension(WIDTH_FRAME,HEIGHT_FRMAE));
		setLocationRelativeTo(null);
		setResizable(Boolean.FALSE);
	}

	@Override
	void initComponents() {
		mainPanel = new MainPanel();
		add(mainPanel);
	}
}
