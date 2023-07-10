package com.tokio.school.app.menubar.menufile.menuitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JMenuItem;

public class SaveMenuItem extends JMenuItem implements ActionListener {

	protected static final String TXT_MENU_ITEM = "Guardar";
	
	public SaveMenuItem() {
		super(TXT_MENU_ITEM);
		initComponent();		
	}
	
	protected void initComponent() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	protected void exit() {
		System.exit(1);
	}
	
	public void clearAllListener() {
		for(ActionListener act : this.getActionListeners()) {
		    this.removeActionListener(act);
		}
	}
	
}
