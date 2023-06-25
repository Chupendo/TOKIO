package com.tokio.school.swing.button.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Button implements ActionListener {
	protected JButton bttn;
	private static Logger LOG = LogManager.getLogger(Button.class);
	
	public Button(String msg) {
		// create a JButton
		this.bttn = new JButton(msg);
	}

	public void registerListenerAction() {
		// register the button to listener action
		this.bttn.addActionListener(this);
	}
	public void registerListenerAction(ActionListener altn) {
		// register the button to listener action
		this.bttn.addActionListener(altn);
	}
	
	public void  removeListenerAction() {
		// remove the  button to listener action
		this.bttn.removeActionListener(this);
	}
	public void removeListenerAction(ActionListener altn) {
		// remove the button to listener action
		this.bttn.removeActionListener(altn);
	}
		
	public JButton getBttn() {
		return this.bttn;
	}
	
	/*
	 * Method to process event of button
	 * no tiene acceso a componetes externos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		LOG.info(e);
	}
}
