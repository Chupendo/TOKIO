package com.tokio.school.swing.ejer15;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MismathFrame extends JFrame {

	JPanel btnPanel, inputPanel, resulPanel, genericPanel;
	JButton comBtn;
	JLabel nameFileALabel, nameFileBLabel, resultLabel;
	JTextField nameFileAField, nameFileBField;
	JCheckBox showPostionChBox;

	public MismathFrame() {
		setLayout(new FlowLayout());

		genericPanel = new JPanel();
		genericPanel.setLayout(new BoxLayout(genericPanel, BoxLayout.Y_AXIS));
		add(genericPanel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(300, 150));
		setResizable(Boolean.FALSE);
		setLocationRelativeTo(null);

		initInputPanel();
		initBtnPanel();
		initResulPanel();

		genericPanel.add(inputPanel);
		genericPanel.add(btnPanel);
		genericPanel.add(resulPanel);

		setVisible(Boolean.TRUE);
	}

	protected void initBtnPanel() {
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 2));

		showPostionChBox = new JCheckBox("Show Position");
		btnPanel.add(showPostionChBox);

		comBtn = new JButton("Comparar");
		comBtn.addActionListener((ae) -> evenComparatorField(ae));
		btnPanel.add(comBtn);
	}

	protected void initInputPanel() {
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2, 2));
		nameFileALabel = new JLabel("Filea A:");
		nameFileAField = new JTextField(10);

		nameFileBLabel = new JLabel("Filea B:");
		nameFileBField = new JTextField(10);

		inputPanel.add(nameFileALabel);
		inputPanel.add(nameFileAField);
		inputPanel.add(nameFileBLabel);
		inputPanel.add(nameFileBField);

	}

	protected void initResulPanel() {
		resulPanel = new JPanel();
		resulPanel.setLayout(new BoxLayout(resulPanel, BoxLayout.X_AXIS));

		resultLabel = new JLabel("Mistmach");
		resulPanel.add(resultLabel);

	}

	protected void evenComparatorField(ActionEvent ae) {
		JOptionPane.showConfirmDialog(null, "Comparando....", "Progess", JOptionPane.WARNING_MESSAGE);

		String txtA = nameFileAField.getText();
		String txtB = nameFileBField.getText();

		int pos = getPostionError(txtA, txtB);
		String resul;
		switch (pos) {
		case -1:
			resul = String.format("Mistmach all");
			break;
		default:
			if (showPostionChBox.isSelected()) {
				resul = String.format("Mistmach in %d",pos);
			} else {
				resul = String.format("Mistmach");
			}
		}
		
		resultLabel.setText(resul);
	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> new MismathFrame());
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getPostionError(String txtA, String txtB) {
		char[] aTxtA, aTxtB;
		aTxtA = txtA.toCharArray();
		aTxtB = txtB.toCharArray();
		return Arrays.mismatch(aTxtA, aTxtB);
	}
}
