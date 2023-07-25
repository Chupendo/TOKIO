package com.tokio.school.calculator.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Getter;

public class BottonNumericPanel extends PanelAbstract {
	private static final short N_COLS = 4;
	private static final short N_ROWS = 4;
	@Getter protected Vector<JButton> vButtonNumeric;
	
	public BottonNumericPanel() {
		confingPanel();
		initComponents();
	}
	
	@Override
	void confingPanel() {
		GridLayout gridLayout = new GridLayout(N_ROWS,N_COLS);
				
		gridLayout.setHgap(5);
	    gridLayout.setVgap(5);
	    
	    setLayout(gridLayout);
	}

	@Override
	void initComponents() {
		vButtonNumeric = new Vector<>();
		// rows 1
		vButtonNumeric.add(new JButton("1"));
		vButtonNumeric.add(new JButton("2"));
		vButtonNumeric.add(new JButton("3"));
		vButtonNumeric.add(new JButton("+"));
		// rows 2
		vButtonNumeric.add(new JButton("4"));
		vButtonNumeric.add(new JButton("5"));
		vButtonNumeric.add(new JButton("6"));
		vButtonNumeric.add(new JButton("-"));
		// rows 4
		vButtonNumeric.add(new JButton("7"));
		vButtonNumeric.add(new JButton("8"));
		vButtonNumeric.add(new JButton("9"));
		vButtonNumeric.add(new JButton("*"));
		// rows 5
		vButtonNumeric.add(new JButton("0"));
		vButtonNumeric.add(new JButton("."));
		vButtonNumeric.add(new JButton("="));
		vButtonNumeric.add(new JButton("/"));
		
		for(JButton btn:vButtonNumeric) {
			JPanel panelBotton  = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
			btn.setPreferredSize(new Dimension(45,30));
			panelBotton.add(btn);
			add(panelBotton);
		}
	}
}
