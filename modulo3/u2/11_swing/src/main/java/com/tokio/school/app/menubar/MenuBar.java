package com.tokio.school.app.menubar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.tokio.school.app.menubar.menuedit.MenuEdit;
import com.tokio.school.app.menubar.menufile.MenuFile;
import com.tokio.school.app.menubar.menuhelp.MenuHelp;
import com.tokio.school.app.menubar.menutool.MenuTool;

public class MenuBar extends JMenuBar{

	protected JMenu file, edit, tool, help;
	public MenuBar() {
		initComponet();
	}
	
	protected void initComponet() {
		file = new MenuFile();
		add(file);
		
		edit = new MenuEdit();
		add(edit);
		
		tool = new MenuTool();
		add(tool);
		
		help = new MenuHelp();
		add(help);
	}

	public JMenu getFile() {
		return file;
	}

	public JMenu getEdit() {
		return edit;
	}

	public JMenu getTool() {
		return tool;
	}

	public JMenu getHelp() {
		return help;
	}	
	
}
