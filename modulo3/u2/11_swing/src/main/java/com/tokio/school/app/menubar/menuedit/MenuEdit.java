package com.tokio.school.app.menubar.menuedit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuEdit extends JMenu implements ActionListener {

	protected static final String TXT_MENU = "Editar";
	public JMenuItem itmEdit;
	
	public MenuEdit() {
		super(TXT_MENU);
		initComponent();
	}
	
	public void initComponent() {
		itmEdit = new JMenuItem("Activar");
		add(itmEdit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
