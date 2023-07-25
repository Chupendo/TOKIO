package com.tokio.school.calculator.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;

import lombok.Getter;

public class ButtonGenericPanel extends PanelAbstract {
	private static final short N_COLS = 3;
	private static final short N_ROWS = 1;
	@Getter protected BottonNumericPanel bottonNumericPanel;
	@Getter protected BottonExtraPanel bottonExtraPanel;
	public ButtonGenericPanel() {
		confingPanel();
		initComponents();
	}
	
	@Override
	void confingPanel() {
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
	}

	@Override
	void initComponents() {
		bottonNumericPanel = new BottonNumericPanel();
		add(bottonNumericPanel);
		
		bottonExtraPanel = new BottonExtraPanel();
		//bottonExtraPanel.setPreferredSize(new Dimension(80,10));
		add(bottonExtraPanel);
	}
}
