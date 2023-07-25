package com.tokio.school.calculator.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Getter;

public class BottonExtraPanel extends PanelAbstract {
	private static final short N_COLS = 1;
	private static final short N_ROWS = 4;
	private 
	
	@Getter
	Vector<JButton> vBottonExtra;

	public BottonExtraPanel() {
		confingPanel();
		initComponents();

	}

	@Override
	void confingPanel() {
		GridLayout gridLayout = new GridLayout(N_ROWS, N_COLS);
		gridLayout.setVgap(10);
		
		setLayout(gridLayout);

	}

	@Override
	void initComponents() {
		vBottonExtra = new Vector<>();

		vBottonExtra.add(new JButton("C"));
		vBottonExtra.add(new JButton("Limpiar"));
		vBottonExtra.add(new JButton("Guardar"));
		vBottonExtra.add(new JButton("Recuperar"));

		for (JButton btn : vBottonExtra) {
			JPanel panelBotton  = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
			btn.setPreferredSize(new Dimension(75,30));
			panelBotton.add(btn);
			add(panelBotton);
		}
	}
}
