package com.tokio.school.app.menubar.menufile.menuitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class OpenMenuItem extends JMenuItem implements ActionListener {

	protected static final String TXT_MENU_ITEM = "Abrir";
	
	public OpenMenuItem() {
		super(TXT_MENU_ITEM);
		initComponent();		
	}
	
	protected void initComponent() {
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(("open"));
	}
	
	public void clearAllListener() {
		for(ActionListener act : this.getActionListeners()) {
		    this.removeActionListener(act);
		}
	}
}
