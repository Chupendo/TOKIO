package com.tokio.school.app.menubar.menufile;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.tokio.school.app.menubar.menufile.menuitem.ExitMenuItem;
import com.tokio.school.app.menubar.menufile.menuitem.OpenMenuItem;
import com.tokio.school.app.menubar.menufile.menuitem.SaveMenuItem;

public class MenuFile extends JMenu {

	protected static final String TXT_MENU = "Archivo";
	protected JMenuItem mItOpen, mISave, mIExit;
	
	public MenuFile() {
		super(TXT_MENU);
		initComponent();
	}
	
	public void initComponent() {
		mItOpen = new OpenMenuItem();
		add(mItOpen);
				
		mISave = new SaveMenuItem();
		add(mISave);
		
		mIExit = new ExitMenuItem();
		add(mIExit);
	}

	public JMenuItem getmItOpen() {
		return mItOpen;
	}

	public JMenuItem getmIExit() {
		return mIExit;
	}
	
	public JMenuItem getmISave() {
		return mISave;
	}
	public void clearAllListener() {
		for(ActionListener act : this.getActionListeners()) {
		    this.removeActionListener(act);
		}
	}
	
	

}
