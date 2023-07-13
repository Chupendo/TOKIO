package com.tokio.school.swing.ejer16.frames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class ListFrame extends FrameAbstract {

	protected JPanel genericPanel, btnPanel;
	protected JList<Object> list;
	protected static String[] lData = { "Manzana", "Platano", "Kiwi", "Fresa" };
	protected JButton btn;
	protected JLabel text;

	public ListFrame() {
		confingFrame();
		initComponents();

		setVisible(Boolean.TRUE);
	}

	@Override
	public void confingFrame() {
		setLayout(new FlowLayout());
		setSize(new Dimension(300, 150));
		setResizable(Boolean.FALSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void initComponents() {
		genericPanel = new JPanel();
		genericPanel.setLayout(new BoxLayout(genericPanel, BoxLayout.X_AXIS));
		add(genericPanel);

		list = new JList<>(lData);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		genericPanel.add(list);

		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(2, 1));
		genericPanel.add(btnPanel);

		btn = new JButton("Cargar");
		btn.addActionListener((ae)->selectEvent(ae));
		btnPanel.add(btn);

		text = new JLabel("Selected: ");
		btnPanel.add(text);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ListFrame());
	}
	
	protected void selectEvent(ActionEvent ae) {
		int indexSelect[] = list.getSelectedIndices();
		String msg = String.format(" Selected: ");
		for(int i=0;i<indexSelect.length;i++) {
			 msg += String.format(" %s ",lData[indexSelect[i]]);
		}
		text.setText(msg);
	}
}
