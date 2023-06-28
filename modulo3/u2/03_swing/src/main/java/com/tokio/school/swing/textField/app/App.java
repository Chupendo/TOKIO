package com.tokio.school.swing.textField.app;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.tokio.school.swing.texts.Constans;

public class App {
	JFrame jFrm;
	JTextField jTxtF;
	JButton jBtn;
	JLabel jLabPrompt, jlabContents;
	ActionListener act;

	App() {
		// Contendero pesado
		this.jFrm = new JFrame();
		this.jFrm.setSize(Constans.APP_WIDTH, Constans.APP_LENGTH);
		this.jFrm.setLayout(new FlowLayout()); // administrador de diseño
		this.jFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Crear un campo de texto
		this.jTxtF = new JTextField(Constans.APP_WITCH_TEXT_FIELD_IN_COLUMN);
		this.jTxtF.setActionCommand("myTF"); // establce el comando de accion
		
		// JLabel
		this.jLabPrompt = new JLabel(Constans.APP_LABEL_PROMPT);
		this.jlabContents = new JLabel(Constans.APP_LABEL_CONTENTS_EMPTY);
		
		// JButton
		this.jBtn = new JButton(Constans.APP_TEXT_BTN);
		
		// registro de escuchadores
		// eventos diferntes
		//this.jTxtF.addActionListener(e ->{	getReset(); 	}); // evento de text field
		//this.jBtn.addActionListener(e ->{	getButton();	}); // evento para el button
		
		// evento compartido
		ActionListener al = (e) -> acction(e);
		this.jTxtF.addActionListener(al);
		this.jBtn.addActionListener(al);
		
		// inserte the components
		this.jFrm.add(this.jLabPrompt);
		this.jFrm.add(this.jTxtF);
		this.jFrm.add(this.jBtn);
		this.jFrm.add(this.jlabContents);
		
		// Agregamos la vista
		jFrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new App());
	}

	/*
	 * Se ha presioando el botton
	 */
	public void getButton() {
		MessageFormat msg = new MessageFormat(Constans.APP_LABEL_CONTENTS);
		Object[] params = {jTxtF.getText()};
		System.out.println(msg.format(params));
	}
	
	/**
	 * Se ha presionado intro cuando se teneia el focus en el input
	 */
	public void getReset() {
		jTxtF.setText(Constans.APP_LABEL_CONTENTS_EMPTY);
		jlabContents.setText(Constans.APP_LABEL_CONTENTS_EMPTY);
	}
	
	/**
	 * Action common
	 */
	public void acction(ActionEvent ae) {
		String value = jTxtF.getText();
		if(ae.getActionCommand().equals("myTF") || value.isBlank()) {
			// text field is empty or pressed into when was focused into textField
			jTxtF.setText(Constans.APP_LABEL_CONTENTS_EMPTY);
			jlabContents.setText(Constans.APP_LABEL_CONTENTS_EMPTY);
		}else {
			MessageFormat msg = new MessageFormat(Constans.APP_LABEL_CONTENTS);
			Object[] params = {jTxtF.getText()};
			
			jlabContents.setText(msg.format(params));
		}
	}
}
