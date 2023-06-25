package com.tokio.school.swing.button.App;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tokio.school.swing.button.buttons.Button;
import com.tokio.school.swing.button.texts.Constans;

public class App {
	protected static JFrame jFrm;
	protected static JLabel jlbl;
	private static Runnable th = ()->new App();
	private static Logger LOG = LogManager.getLogger(App.class);
	
	App(){
		// Contendero pesado
		jFrm = new JFrame();
		jFrm.setSize(Constans.APP_WIDTH,Constans.APP_LENGTH);
		jFrm.setLayout(new FlowLayout()); // administrador de diseño
		jFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Creamos los botnoes
		Button btnUp = new Button(Constans.APP_ACCTION_COMMAND.BTN_UP.toString());
		Button btnDown = new Button(Constans.APP_ACCTION_COMMAND.BTN_DOWN.toString());
		
		/** Registro de eventos **/
		// default event (defined in the class Button)
		btnUp.registerListenerAction( );
		btnDown.registerListenerAction( );

		// difernte event
		//btnUp.registerListenerAction( (ActionEvent e)->{	pressBttnUp(e.getActionCommand());		});
		//btnDown.registerListenerAction( (ActionEvent e)->{	pressBttnDown(e.getActionCommand());	});
		
		// common event
		ActionListener btnListnUpDown = (ActionEvent e)->{	pressBttn(e.getActionCommand());	};
		btnUp.registerListenerAction(btnListnUpDown);
		btnDown.registerListenerAction(btnListnUpDown);
		/** fin de registro de eventos **/
		
		// Agregamos los botones a la ventana
		jFrm.add(btnUp.getBttn());
		jFrm.add(btnDown.getBttn());
	
		
		// Cremos un Lable
		jlbl = new JLabel(Constans.APP_LABEL_MSG_ACTION_1);
		//jlbl.setVisible(false);
		jFrm.add(jlbl);
		
		// Agregamos la vista 
		jFrm.setVisible(true);

	}
	
	public static void main(String[] args) {
		LOG.info("Start");
		SwingUtilities.invokeLater(th);
	}

	/** Method logic event **/
	public static void pressBttn(String acctionCommand) {
		Constans.APP_ACCTION_COMMAND cmd = Constans.APP_ACCTION_COMMAND.valueOf(acctionCommand);
		if(Constans.APP_ACCTION_COMMAND.BTN_UP.equals(cmd)) {
			jlbl.setText(Constans.APP_LABEL_MSG_UP_WAS_PRESS);
			return;
		}
		if(Constans.APP_ACCTION_COMMAND.BTN_DOWN.equals(cmd)) {
			jlbl.setText(Constans.APP_LABEL_MSG_DOWN_WAS_PRESS);
			return;
		}
		jlbl = new JLabel(Constans.APP_LABEL_MSG_ACTION_1);
	}
	public static void pressBttnUp(String acctionCommand) {
		jlbl.setText(Constans.APP_LABEL_MSG_UP_WAS_PRESS);
		
	}
	public static void pressBttnDown(String acctionCommand) {
		jlbl.setText(Constans.APP_LABEL_MSG_DOWN_WAS_PRESS);
	}
}
