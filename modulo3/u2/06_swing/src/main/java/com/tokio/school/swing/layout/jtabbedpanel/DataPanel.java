package com.tokio.school.swing.layout.jtabbedpanel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DataPanel extends JPanel {

	private JTabbedPane tabbedPane;
	private JPanel customersPanel, ordersPanel, providersPanel;

	public DataPanel() {
		super();
		setLayout(new GridLayout(3, 2));
		initComponents();
	}

	protected void initComponents() {
		customersPanel = new JPanel();
		customersPanel.add(new JButton("ok"));
		customersPanel.add(new JButton("cancelar"));
		ordersPanel= new JPanel();
		providersPanel= new JPanel();
		
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("agregar",customersPanel);
		tabbedPane.addTab("editar",ordersPanel);
		tabbedPane.addTab("borrar",new JPanel());
		add(tabbedPane);
		
	}
}
