package com.tokio.school.swing.progessbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoadFrame extends FrameAbstract {

	protected JButton startBtn, stopBtn;
	protected static JProgressBar loadProgressBar;
	protected JPanel mainPanel, btnPanel, loadPanel;
	protected JLabel texto;
	protected ThreadCarga hilo;

	public LoadFrame() {
		configFrame();
		initComponents();
		setVisible(Boolean.TRUE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new LoadFrame());
	}

	@Override
	void configFrame() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(350, 150));
		setResizable(Boolean.FALSE);
		setLocationRelativeTo(null);
	}

	@Override
	void initComponents() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBounds(100, 20, 0, 0);

		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 2));

		loadPanel = new JPanel();
		loadPanel.setLayout(new GridLayout(2, 1));

		mainPanel.add(btnPanel);
		mainPanel.add(loadPanel);

		// btn panel
		startBtn = new JButton("Start");
		startBtn.addActionListener((ae) -> eventStartLoad(ae));
		btnPanel.add(startBtn);

		stopBtn = new JButton("Stop");
		stopBtn.addActionListener((ae) -> eventStoptLoad(ae));
		btnPanel.add(stopBtn);

		// load panel
		loadProgressBar = new JProgressBar();
		loadProgressBar.setValue(0);
		loadProgressBar.setStringPainted(true);
		loadPanel.add(loadProgressBar);

		texto = new JLabel("Cargando ...");
		loadPanel.add(texto);

		// main panel
		getContentPane().add(mainPanel);

		hilo = null;

	}

	private void eventStartLoad(ActionEvent ae) {
		if (hilo == null) {
			hilo = ThreadCarga.createAndStart("Load", loadProgressBar,texto);
		}
	
	}

	private void eventStoptLoad(ActionEvent ae) {
		if (hilo != null) {
			hilo.stopLoad();
			hilo = null;
		}
		texto.setText("Stop!");
	}
}
