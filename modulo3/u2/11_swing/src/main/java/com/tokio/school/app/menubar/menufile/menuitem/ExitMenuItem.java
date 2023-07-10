package com.tokio.school.app.menubar.menufile.menuitem;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ExitMenuItem extends JMenuItem implements ActionListener {

	protected static final String TXT_MENU_ITEM = "Salir";
	
	public ExitMenuItem() {
		super(TXT_MENU_ITEM);
		initComponent();		
	}
	
	protected void initComponent() {
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(("Salir"));
		// -1 si le da a x, 0 si le da si, 1 si le da a no, 2 si le da a cancelar
		int res = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?","Exit",JOptionPane.WARNING_MESSAGE);
		
		if(res == JOptionPane.OK_OPTION) {
			exit();
		}
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
